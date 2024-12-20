package com.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Company;
import com.demo.exception.CompanyNotFoundException;
import com.demo.repository.CompanyRepository;
import com.demo.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // Add a new company
    @Override
    public Company addCompany(Company company) {
        // Save the company details
        return companyRepository.save(company);
    }

    // Retrieve all companies
    @Override
    public List<Company> getAllCompanies() {
        // Return the list of all companies
        return companyRepository.findAll();
    }

    // Retrieve a company by ID
    @Override
    public Company getCompanyById(Long companyId) throws CompanyNotFoundException {
        // Find the company by its ID, or throw an exception if not found
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("Company not found with ID: " + companyId));
    }

    // Update a company's details
    @Override
    public Company updateCompany(Long companyId, Company updatedCompany) throws CompanyNotFoundException {
        Company existingCompany = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("Company not found with ID: " + companyId));

        // Update the existing company details
        existingCompany.setCompanyName(updatedCompany.getCompanyName());
        existingCompany.setCompanyEmail(updatedCompany.getCompanyEmail());
        existingCompany.setCompanyPhone(updatedCompany.getCompanyPhone());
        // Save the updated details
        return companyRepository.save(existingCompany);
    }
    
   

  
    
}
