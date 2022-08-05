package com.example.onboarding.repositories;

import com.example.onboarding.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByTaxPayerId(int taxPayerId);

    Employee findByCompanyCompanyName(String companyName);
}
