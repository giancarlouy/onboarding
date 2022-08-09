package com.example.onboarding.services;

import com.example.onboarding.dto.CompanyDto;
import com.example.onboarding.entities.Company;

public interface CompanyService {

    Company createCompany(CompanyDto companyDto);

    Company getCompanyByCompanyNameAndCountry(String companyName, String country);
}
