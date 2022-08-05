package com.example.onboarding.dto;

public class CompanyDto {

    private int companyId;
    private String companyName;
    private String country;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
