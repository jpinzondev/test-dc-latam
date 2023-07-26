package com.dc.latam.domain.dto;

public class DomainEmployee {
    private Long id;
    private String employeeName;
    private int employeeSalary;
    private int employeeAnualSalary;
    private int employeeAge;
    private String profileImage;

    public DomainEmployee(Long id, String employeeName, int employeeSalary, int employeeAge, String profileImage) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.profileImage = profileImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getEmployeeAnualSalary() {
        return employeeAnualSalary;
    }
    public void setEmployeeAnualSalary(int employeeAnualSalary) {
        this.employeeAnualSalary = employeeAnualSalary;
    }
}
