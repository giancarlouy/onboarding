package com.example.onboarding.services;

import com.example.onboarding.dto.CompanyDto;
import com.example.onboarding.entities.Company;
import com.example.onboarding.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "australia"})
public class CompanyAustraliaService implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createCompany(CompanyDto companyDto) {
        Company company = new Company();

        company.setCompanyName(companyDto.getCompanyName());
        company.setCountry(companyDto.getCountry());

        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyByCompanyNameAndCountry(String companyName, String country) {
        return companyRepository.findByCompanyNameAndCountry(companyName, country);
    }
}
