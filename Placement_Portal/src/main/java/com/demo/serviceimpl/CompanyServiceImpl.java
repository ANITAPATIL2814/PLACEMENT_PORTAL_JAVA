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

    @Override
    public Company addCompany(Company company) {
        // Logic to save the company using the repository
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        // Logic to retrieve all companies
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long companyId) throws CompanyNotFoundException {
        // No need for 'throws' because CompanyNotFoundException is unchecked (runtime exception)
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("Company not found with ID: " + companyId));
    }

}
