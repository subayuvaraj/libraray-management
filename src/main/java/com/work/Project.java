package com.work;

import java.time.LocalDate;

public class Project {

    private String projectCode;
    private String projectName;
    private String clientName;
    private LocalDate startDate;
    private LocalDate endDate;

    public Project() {
    }

    public Project(String projectCode,
                   String projectName,
                   String clientName,
                   LocalDate startDate,
                   LocalDate endDate) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.clientName = clientName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectCode='" + projectCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}