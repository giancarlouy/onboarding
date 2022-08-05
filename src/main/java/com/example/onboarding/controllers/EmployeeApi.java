package com.example.onboarding.controllers;

import com.example.onboarding.dto.EmployeeDto;
import com.example.onboarding.entities.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/employees")
public interface EmployeeApi {

    @RequestMapping(value = "/employee", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employeeDto);

    @RequestMapping(value = "/employee/{taxPayerId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    ResponseEntity<Employee> getEmployeeByTaxPayerId(@PathVariable int taxPayerId);

    @RequestMapping(value = "/employee", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    ResponseEntity<Employee> getEmployeeByCompanyName(@RequestParam(value = "companyName") String companyName);
}
