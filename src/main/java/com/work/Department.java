package com.work;

public class Department {

    private Long departmentId;
    private String departmentName;
    private String location;
    private Manager manager;

    // No-Args Constructor
    public Department() {
    }

    // Parameterized Constructor
    public Department(Long departmentId,
                      String departmentName,
                      String location,
                      Manager manager) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.location = location;
        this.manager = manager;
    }

    // Getters

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getLocation() {
        return location;
    }

    public Manager getManager() {
        return manager;
    }

    // Setters

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", location='" + location + '\'' +
                ", manager=" + manager +
                '}';
    }
}