package com.example.onboarding.controllers;

import com.example.onboarding.OnboardingApplication;
import com.example.onboarding.dto.CompanyDto;
import com.example.onboarding.entities.Company;
import com.example.onboarding.repositories.CompanyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {OnboardingApplication.class})
@AutoConfigureMockMvc
public class CompanyApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CompanyRepository companyRepository;

//    @Test
//    public void createCompanyTest() throws Exception {
//        CompanyD
//    }

    @Test
//    @Transactional
    public void createCompanyTest() throws Exception {
        CompanyDto companyDto = new CompanyDto();

        companyDto.setCompanyName("Finstro Philippines");
        companyDto.setCountry("Philippines");

        MvcResult result = mockMvc
                .perform(post("/companies/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(companyDto)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void getCompanyByCompanyNameAndCountryTest() throws Exception {
        CompanyDto companyDto = new CompanyDto();

        companyDto.setCompanyName("Finstro Philippines");
        companyDto.setCountry("Philippines");

        MvcResult result = mockMvc
                .perform(post("/companies/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(companyDto)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        System.out.println("This is the result: " + objectMapper.readValue(result.getResponse().getContentAsString(), Company.class));

//        MvcResult mvcResult = mockMvc
    }
}
