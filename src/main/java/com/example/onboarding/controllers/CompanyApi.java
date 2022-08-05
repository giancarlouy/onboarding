package com.example.onboarding.controllers;

import com.example.onboarding.dto.CompanyDto;
import com.example.onboarding.entities.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/companies")
public interface CompanyApi {

    @RequestMapping(value = "/company", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    ResponseEntity<Company> createCompany(@RequestBody CompanyDto companyDto);

    @RequestMapping(value = "/{companyName}/{country}", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<Company> getCompanyByCompanyNameAndCountry(@PathVariable String companyName, @PathVariable String country);

}
