package com.example.onboarding.controllers;

import com.example.onboarding.dto.CompanyDto;
import com.example.onboarding.entities.Company;
import com.example.onboarding.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Validated
public class CompanyApiController implements CompanyApi {

    @Autowired
    private CompanyService companyService;

    @Override
    public ResponseEntity<Company> createCompany(@RequestBody CompanyDto companyDto) {
        Company company = companyService.createCompany(companyDto);
        return ResponseEntity.ok().body(company);
    }

    @Override
    public ResponseEntity<Company> getCompanyByCompanyNameAndCountry(@PathVariable String companyName, @PathVariable String country) {
        Company company = companyService.getCompanyByCompanyNameAndCountry(companyName, country);
        return ResponseEntity.ok().body(company);
    }

}
