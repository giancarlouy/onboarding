package com.example.onboarding.controllers;

import com.example.onboarding.dto.EmployeeDto;
import com.example.onboarding.entities.Company;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("default")
public class EmployeeApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createEmployeeTest() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Company company = new Company();

        company.setCompanyName("Finstro Philippines");
        company.setCountry("Philippines");

        employeeDto.setFirstName("Gian");
        employeeDto.setLastName("Uy");
        employeeDto.setTaxPayerId(1);
        employeeDto.setCompany(company);

        mockMvc.perform(post("/employees/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeDto)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void getEmployeeByTaxPayerId() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Company company = new Company();

        company.setCompanyName("Finstro Australia");
        company.setCountry("Australia");

        employeeDto.setFirstName("Anil");
        employeeDto.setLastName("Palat");
        employeeDto.setTaxPayerId(2);
        employeeDto.setCompany(company);

        mockMvc.perform(post("/employees/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeDto)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        mockMvc.perform(get("/employees/employee/{taxPayerId}", employeeDto.getTaxPayerId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void getEmployeeByCompanyName() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        Company company = new Company();

        company.setCompanyName("Finstro United States");
        company.setCountry("Finstro United States");

        employeeDto.setFirstName("Alyssa");
        employeeDto.setLastName("Romero");
        employeeDto.setTaxPayerId(3);
        employeeDto.setCompany(company);

        mockMvc.perform(post("/employees/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeDto)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        mockMvc.perform(get("/employees/employee")
                        .content(objectMapper.writeValueAsString(employeeDto))
                        .param("companyName", "Finstro United States"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
}
