package com.example.onboarding.repositories;

import com.example.onboarding.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByCompanyNameAndCountry(String companyName, String country);

}
