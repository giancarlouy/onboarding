package com.example.onboarding.controllers;

import com.example.onboarding.dto.EmployeeDto;
import com.example.onboarding.entities.Company;
import com.example.onboarding.entities.Employee;
import com.example.onboarding.repositories.EmployeeRepository;
import com.example.onboarding.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
public class EmployeeApiControllerTest {

    @InjectMocks
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeService employeeServiceSpy;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void createEmployeeTest() throws Exception {
        Employee employeeTest = new Employee();
        EmployeeDto employeeDto = new EmployeeDto();
        Company company = new Company();

        company.setCompanyName("Finstro Philippines");
        company.setCountry("Philippines");

        employeeDto.setFirstName("Gian");
        employeeDto.setLastName("Uy");
        employeeDto.setTaxPayerId(1);
        employeeDto.setCompany(company);

        Employee employeeResponse = employeeService.createEmployee(employeeDto);

        System.out.println("Awit: " + employeeResponse);

        assertNotNull(employeeResponse);
    }
}
