package com.example.onboarding.services;

import com.example.onboarding.dto.EmployeeDto;
import com.example.onboarding.entities.Company;
import com.example.onboarding.entities.Employee;
import com.example.onboarding.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@ActiveProfiles("default")
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void createEmployeeTest() {
        EmployeeDto employeeDto = new EmployeeDto();
        Company company = new Company();

        company.setCompanyName("Finstro Philippines");
        company.setCountry("Philippines");

        employeeDto.setFirstName("Gian");
        employeeDto.setLastName("Uy");
        employeeDto.setTaxPayerId(1);
        employeeDto.setCompany(company);

        Employee employee = employeeService.createEmployee(employeeDto);

        assertNotNull(employee);

        assertEquals(employee.getFirstName(), employeeDto.getFirstName());
        assertEquals(employee.getLastName(), employeeDto.getLastName());
        assertEquals(employee.getTaxPayerId(), employeeDto.getTaxPayerId());
        assertEquals(employee.getCompany().getCompanyName(), employeeDto.getCompany().getCompanyName());
        assertEquals(employee.getCompany().getCountry(), employeeDto.getCompany().getCountry());
    }

    @Test
    public void getEmployeeByTaxPayerId() {
        Employee employee = new Employee();
        Company company = new Company();

        company.setCompanyName("Finstro Australia");
        company.setCountry("Australia");

        employee.setFirstName("Anil");
        employee.setLastName("Palat");
        employee.setTaxPayerId(2);
        employee.setCompany(company);

        employeeRepository.save(employee);

        Employee expectedEmployee = employeeService.getEmployeeByTaxPayerId(2);

        assertNotNull(expectedEmployee);

        assertEquals(expectedEmployee.getFirstName(), employee.getFirstName());
        assertEquals(expectedEmployee.getLastName(), employee.getLastName());
        assertEquals(expectedEmployee.getTaxPayerId(), employee.getTaxPayerId());
        assertEquals(expectedEmployee.getCompany().getCompanyName(), employee.getCompany().getCompanyName());
        assertEquals(expectedEmployee.getCompany().getCountry(), employee.getCompany().getCountry());
    }

    @Test
    public void getEmployeeByCompanyName() {
        Employee employee = new Employee();
        Company company = new Company();

        company.setCompanyName("Finstro United States");
        company.setCountry("United States");

        employee.setFirstName("Alyssa");
        employee.setLastName("Romero");
        employee.setTaxPayerId(3);
        employee.setCompany(company);

        employeeRepository.save(employee);

        Employee expectedEmployee = employeeService.getEmployeeByCompanyName(company.getCompanyName());

        assertNotNull(expectedEmployee);

        assertEquals(expectedEmployee.getFirstName(), employee.getFirstName());
        assertEquals(expectedEmployee.getLastName(), employee.getLastName());
        assertEquals(expectedEmployee.getTaxPayerId(), employee.getTaxPayerId());
        assertEquals(expectedEmployee.getCompany().getCompanyName(), employee.getCompany().getCompanyName());
        assertEquals(expectedEmployee.getCompany().getCountry(), employee.getCompany().getCountry());
    }
}
