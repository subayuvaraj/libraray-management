package com.work;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Employee {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private LocalDate joiningDate;
    private BigDecimal salary;

    private Address address;
    private Department department;
    private List<Project> projects;
    private List<Skill> skills;
    private EmergencyContact emergencyContact;

    // No Args Constructor
    public Employee() {
    }

    // Parameterized Constructor
    public Employee(Long employeeId,
                    String firstName,
                    String lastName,
                    String email,
                    String phoneNumber,
                    LocalDate dateOfBirth,
                    LocalDate joiningDate,
                    BigDecimal salary,
                    Address address,
                    Department department,
                    List<Project> projects,
                    List<Skill> skills,
                    EmergencyContact emergencyContact) {

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.joiningDate = joiningDate;
        this.salary = salary;
        this.address = address;
        this.department = department;
        this.projects = projects;
        this.skills = skills;
        this.emergencyContact = emergencyContact;
    }

    // Getters

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Address getAddress() {
        return address;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    // Setters

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", joiningDate=" + joiningDate +
                ", salary=" + salary +
                ", address=" + address +
                ", department=" + department +
                ", projects=" + projects +
                ", skills=" + skills +
                ", emergencyContact=" + emergencyContact +
                '}';
    }
}