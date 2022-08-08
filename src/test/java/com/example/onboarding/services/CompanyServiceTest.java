package com.example.onboarding.services;

import com.example.onboarding.OnboardingApplication;
import com.example.onboarding.dto.CompanyDto;
import com.example.onboarding.entities.Company;
import com.example.onboarding.repositories.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnboardingApplication.class)
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void createCompany() {
        CompanyDto companyDto = new CompanyDto();

        companyDto.setCompanyName("Finstro");
        companyDto.setCountry("Australia");

        Company company = companyService.createCompany(companyDto);

        assertNotNull(company);

        assertEquals(companyDto.getCompanyName(), company.getCompanyName());
        assertEquals(companyDto.getCountry(), company.getCountry());
    }

    @Test
    public void getCompanyByCompanyNameAndCountryTest() {
        Company company = new Company();

        company.setCompanyName("Google");
        company.setCountry("United States");

        companyRepository.save(company);

        Company expectedCompany = companyService.getCompanyByCompanyNameAndCountry(company.getCompanyName(), company.getCountry());

        System.out.println("awit: " + company);

        assertNotNull(company);

        assertEquals(expectedCompany.getCompanyName(), company.getCompanyName());
        assertEquals(expectedCompany.getCountry(), company.getCountry());
    }
}
