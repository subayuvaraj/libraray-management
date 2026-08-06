package com.work;

import com.github.javafaker.Faker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class EmployeeGenerator {

    private final Faker faker;

    private final AtomicLong employeeIdSequence =
            new AtomicLong(1000);

    private final AtomicLong departmentIdSequence =
            new AtomicLong(100);

    private final AtomicLong managerIdSequence =
            new AtomicLong(500);

    public EmployeeGenerator() {
        this.faker = new Faker();
    }

    /**
     * Generates the requested number of employees.
     */
    public List<Employee> generateEmployees(int employeeCount) {

        if (employeeCount < 0) {
            throw new IllegalArgumentException(
                    "Employee count cannot be negative"
            );
        }

        return IntStream.range(0, employeeCount)
                .mapToObj(index -> generateEmployee())
                .toList();
    }

    /**
     * Generates one Employee containing nested objects.
     */
    public Employee generateEmployee() {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        LocalDate dateOfBirth = randomDate(
                LocalDate.now().minusYears(60),
                LocalDate.now().minusYears(21)
        );

        LocalDate joiningDate = randomDate(
                LocalDate.now().minusYears(15),
                LocalDate.now()
        );

        return new Employee(
                employeeIdSequence.incrementAndGet(),
                firstName,
                lastName,
                createEmail(firstName, lastName),
                faker.phoneNumber().cellPhone(),
                dateOfBirth,
                joiningDate,
                generateSalary(),
                generateAddress(),
                generateDepartment(),
                generateProjects(),
                generateSkills(),
                generateEmergencyContact()
        );
    }

    /**
     * Generates an Address object.
     */
    private Address generateAddress() {

        return new Address(
                faker.address().streetAddress(),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.address().country()
        );
    }

    /**
     * Generates a Department with a nested Manager.
     */
    private Department generateDepartment() {

        return new Department(
                departmentIdSequence.incrementAndGet(),
                faker.options().option(
                        "Engineering",
                        "Finance",
                        "Human Resources",
                        "Operations",
                        "Risk Management",
                        "Quality Assurance",
                        "Information Security",
                        "Data Analytics"
                ),
                faker.address().city(),
                generateManager()
        );
    }

    /**
     * Generates a Manager object.
     */
    private Manager generateManager() {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        return new Manager(
                managerIdSequence.incrementAndGet(),
                firstName,
                lastName,
                createEmail(firstName, lastName),
                faker.phoneNumber().cellPhone()
        );
    }

    /**
     * Generates between 1 and 4 projects for an employee.
     */
    private List<Project> generateProjects() {

        int projectCount = faker.number()
                .numberBetween(1, 5);

        List<Project> projects = new ArrayList<>();

        for (int index = 0; index < projectCount; index++) {
            projects.add(generateProject());
        }

        return projects;
    }

    /**
     * Generates one Project object.
     */
    private Project generateProject() {

        LocalDate startDate = randomDate(
                LocalDate.now().minusYears(5),
                LocalDate.now()
        );

        LocalDate endDate = startDate.plusMonths(
                faker.number().numberBetween(3, 25)
        );

        return new Project(
                "PRJ-" + faker.number().digits(5),
                faker.app().name(),
                faker.company().name(),
                startDate,
                endDate
        );
    }

    /**
     * Generates between 2 and 5 skills for an employee.
     */
    private List<Skill> generateSkills() {

        List<String> availableSkills = List.of(
                "Java",
                "Spring Boot",
                "Spring Batch",
                "Oracle",
                "PostgreSQL",
                "Kafka",
                "ActiveMQ",
                "Docker",
                "Kubernetes",
                "AWS",
                "Jenkins",
                "Maven",
                "Git",
                "Terraform"
        );

        int skillCount = faker.number()
                .numberBetween(2, 6);

        List<Skill> skills = new ArrayList<>();

        while (skills.size() < skillCount) {

            String skillName = faker.options()
                    .nextElement(availableSkills);

            boolean alreadyExists = skills.stream()
                    .anyMatch(skill ->
                            skill.getSkillName()
                                    .equalsIgnoreCase(skillName)
                    );

            if (!alreadyExists) {
                skills.add(
                        new Skill(
                                skillName,
                                faker.number().numberBetween(1, 16)
                        )
                );
            }
        }

        return skills;
    }

    /**
     * Generates an EmergencyContact with a nested Address.
     */
    private EmergencyContact generateEmergencyContact() {

        return new EmergencyContact(
                faker.name().fullName(),
                faker.options().option(
                        "Spouse",
                        "Parent",
                        "Sibling",
                        "Friend",
                        "Relative"
                ),
                faker.phoneNumber().cellPhone(),
                generateAddress()
        );
    }

    /**
     * Generates salary between $60,000 and $220,000.
     */
    private BigDecimal generateSalary() {

        double salary = faker.number().randomDouble(
                2,
                60_000,
                220_000
        );

        return BigDecimal.valueOf(salary)
                .setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Generates a random date between the supplied dates.
     */
    private LocalDate randomDate(
            LocalDate startDate,
            LocalDate endDate) {

        long startDay = startDate.toEpochDay();
        long endDay = endDate.toEpochDay();

        long randomDay = ThreadLocalRandom.current()
                .nextLong(startDay, endDay + 1);

        return LocalDate.ofEpochDay(randomDay);
    }

    /**
     * Creates a readable fake corporate email.
     */
    private String createEmail(
            String firstName,
            String lastName) {

        String domain = faker.options().option(
                "example.com",
                "company.com",
                "technology.com",
                "fintech.com"
        );

        return firstName.toLowerCase()
                + "."
                + lastName.toLowerCase()
                + "@"
                + domain;
    }
}
