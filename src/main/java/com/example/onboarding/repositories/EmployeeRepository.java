package com.example.onboarding.repositories;

import com.example.onboarding.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByTaxPayerId(int taxPayerId);

//    List<Employee> findAllByCompanyName(String companyName);

}
