package com.work;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeApplication {

    public static void main(String[] args) {

        EmployeeGenerator generator =
                new EmployeeGenerator();

        List<Employee> employees =
                generator.generateEmployees(10);
        employees.forEach(System.out::println);

        /*employees.stream().filter(e-> {
            if(e.getSalary().compareTo(new BigDecimal("100000"))<0){
                return true;
            }
            return false;
        })
                .peek(System.out::println)
                .collect(Collectors.toList());*/

        fetchEmployeeNames(employees);
        fetchEmployeeByCity(employees);
        printEmployeeCount(employees);
        fetchEmployeeByJoiningDate(employees);
        sortEmployeesBySalaryAscendingOrder(employees);
        sortEmployeesByFirstThenLastName(employees);
        fetchHighestPaidEmployee(employees);
        fetchLeastPaidEmployee(employees);

    }

    private static void fetchLeastPaidEmployee(List<Employee> employees) {
        System.out.println("LeastPaidEmployee : " + employees.stream().min(Comparator.comparing(Employee::getSalary)).get().getSalary());
    }

    private static void fetchHighestPaidEmployee(List<Employee> employees) {
        System.out.println( "HighPaidEmployee : " + employees.stream().max(Comparator.comparing(Employee::getSalary)).get().getSalary());
      //  employees.stream().max(Comparator.comparing(Employee::getSalary));
    }

    private static void sortEmployeesByFirstThenLastName(List<Employee> employees) {
        System.out.println("SortedOrderOfEmployee : "+ employees.stream().sorted(Comparator.comparing((Employee employee) -> employee.getFirstName()).thenComparing(employee -> employee.getLastName())).toList());
       // employees.stream().sorted(Comparator.comparing((Employee employee) -> employee.getFirstName()).thenComparing(employee -> employee.getLastName()));
    }

    private static void sortEmployeesBySalaryAscendingOrder(List<Employee> employees) {
        System.out.println("SortedOrderOfEmployeebySalary : "+ employees.stream().sorted(Comparator.comparing(employee -> employee.getSalary())).toList());
       // employees.stream().sorted(Comparator.comparing(employee -> employee.getSalary())).toList();
    }

    private static void fetchEmployeeByJoiningDate(List<Employee> employees) {

        List<LocalDate> joiningdates = employees.stream().map(employee -> employee.getJoiningDate()).distinct().toList();
        for (int i=1;i<=joiningdates.size();i++)
            System.out.println(i+". "+joiningdates.get(i-1) +"\n");
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the joining date index to get the employee name");
        int  choice= scanner.nextInt();
        List<Employee> employeeList= employees.stream().filter(employee -> employee.getJoiningDate().equals(joiningdates.get(choice-1))).toList();
        employeeList.forEach(System.out::println);
    }

    public static void fetchEmployeeNames(List<Employee> employees) {
        final int j = 0;
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.println(i + 1 + ". Employee Name is " + employee.getFirstName() + " " + employee.getLastName());
        }
        //using Streams
        //employees.stream().forEach(employee -> System.out.println("Employee Name is " + employee.getFirstName()+"  " +employee.getLastName()));
    }
    private static void fetchEmployeeByCity(List<Employee> employees) {
        List<String> cities= employees.stream().map(employee -> employee.getAddress().getCity()).distinct().toList();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter to the City from the list to fetch the employees. " + "The List is " + cities );
        String city=scanner.nextLine();
        List<Employee> employees1 =employees.stream().filter(employee ->( employee.getAddress().getCity()).equalsIgnoreCase(city)).toList();
        System.out.println(employees1);

    }
    private static void printEmployeeCount(List<Employee> employees) {
        System.out.println("Total Number of Emplyees are" + employees.stream().count());
    }

}
