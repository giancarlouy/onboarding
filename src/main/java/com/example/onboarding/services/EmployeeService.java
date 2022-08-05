package com.example.onboarding.services;

import com.example.onboarding.dto.EmployeeDto;
import com.example.onboarding.entities.Employee;
import com.example.onboarding.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setTaxPayerId(employeeDto.getTaxPayerId());
        employee.setCompany(employeeDto.getCompany());

        return employeeRepository.save(employee);
    }

    public Employee getEmployeeByTaxPayerId(int taxPayerId) {
        return employeeRepository.findByTaxPayerId(taxPayerId);
    }

    public List<Employee> getEmployeesByCompany(String companyName) {
//        List<Employee> employees = new ArrayList<>();

//        return employeeRepository.findAllByCompanyName(companyName);

//        employeeRepository.findAll().forEach(employees::add);
        return null;
    }
}
