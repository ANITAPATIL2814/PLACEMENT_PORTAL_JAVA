package com.demo.service;

import java.util.List;

import com.demo.entity.Company;
import com.demo.exception.CompanyNotFoundException;

public interface CompanyService {
    // Add a new company
    Company addCompany(Company company);

    // Retrieve a company by ID
    Company getCompanyById(Long companyId) throws CompanyNotFoundException;

    // Retrieve all companies
    List<Company> getAllCompanies();

  //Update company details
    Company updateCompany(Long companyId, Company updatedCompany) throws CompanyNotFoundException;
   
   
}
