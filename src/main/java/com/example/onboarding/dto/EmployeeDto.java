package com.example.onboarding.dto;

import com.example.onboarding.entities.Company;

public class EmployeeDto {

    private int employeeId;
    private String firstName;
    private String lastName;
    private int taxPayerId;
    private Company company;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTaxPayerId() {
        return taxPayerId;
    }

    public void setTaxPayerId(int taxPayerId) {
        this.taxPayerId = taxPayerId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", taxPayerId=" + taxPayerId +
                ", company=" + company +
                '}';
    }
}
