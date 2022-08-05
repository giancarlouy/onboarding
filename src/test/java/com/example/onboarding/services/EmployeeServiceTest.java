package com.example.onboarding.services;

import com.example.onboarding.dto.EmployeeDto;
import com.example.onboarding.entities.Company;
import com.example.onboarding.entities.Employee;
import com.example.onboarding.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//@RunWith(PowerMockRunner.class)
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeService employeeServiceSpy;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setup() {
        employeeServiceSpy = PowerMockito.spy(employeeService);
    }

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

        System.out.println("Employee Response: " + employeeService.createEmployee(employeeDto));

//        System.out.println("Employee DTO: " + employeeDto);
//
//        System.out.println("putingbox: " + Whitebox.invokeMethod(employeeServiceSpy, "createEmployee", employeeDto));
//        Employee employee = Whitebox.invokeMethod(employeeServiceSpy, "createEmployee", employeeDto);
//
//        System.out.println("Awit: " + employee);

//        assertNotNull(employee);
    }

    @Test
    public void getEmployeeByTaxPayerId() throws Exception {
        int taxPayerId = 1;

        Employee expected = new Employee();

        expected.setFirstName("Gian");
        expected.setLastName("Uy");
//        expected.set
    }
}
