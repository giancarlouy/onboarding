package com.example.onboarding.controllers;

import com.example.onboarding.dto.EmployeeDto;
import com.example.onboarding.entities.Employee;
import com.example.onboarding.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Validated
public class EmployeeApiController implements EmployeeApi {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.createEmployee(employeeDto);
        return ResponseEntity.ok().body(employee);
    }

    @Override
    public ResponseEntity<Employee> getEmployeeByTaxPayerId(@PathVariable int taxPayerId) {
        Employee employee = employeeService.getEmployeeByTaxPayerId(taxPayerId);
        return ResponseEntity.ok().body(employee);
    }

    @Override
    public ResponseEntity<Employee> getEmployeeByCompanyName(@RequestParam(value = "companyName") String companyName) {
        Employee employee = employeeService.getEmployeeByCompany(companyName);
        return ResponseEntity.ok().body(employee);
    }
}
