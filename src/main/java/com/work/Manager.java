package com.work;

public class Manager {

    private Long managerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    // No-Args Constructor
    public Manager() {
    }

    // Parameterized Constructor
    public Manager(Long managerId,
                   String firstName,
                   String lastName,
                   String email,
                   String phoneNumber) {
        this.managerId = managerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters

    public Long getManagerId() {
        return managerId;
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

    // Setters

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
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

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}