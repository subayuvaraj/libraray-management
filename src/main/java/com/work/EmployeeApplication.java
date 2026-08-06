package com.work;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class EmployeeApplication {

    public static void main(String[] args) {

        EmployeeGenerator generator =
                new EmployeeGenerator();

        List<Employee> employees =
                generator.generateEmployees(100);

        employees.stream().filter(e-> {
            if(e.getSalary().compareTo(new BigDecimal("100000"))<0){
                return true;
            }
            return false;
        })
                .peek(System.out::println)
                .collect(Collectors.toList());

        fetchEmployeeNames(employees);

       // employees.forEach(System.out::println);
    }

    public static void fetchEmployeeNames(List<Employee> employees) {
        final int j = 0;
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.println(i + 1 + ". Employee Name is " + employee.getFirstName() + " " + employee.getLastName());
        }
    }
}
