package com.demo.controller;

import com.demo.entity.Company;
import com.demo.exception.CompanyNotFoundException;
import com.demo.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // Add a new company
    @PostMapping("/companyadd")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        Company createdCompany = companyService.addCompany(company);
        return new ResponseEntity<>(createdCompany, HttpStatusCode.valueOf(201));
    }

    // Retrieve a company by ID
    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) throws CompanyNotFoundException {
        Company company = companyService.getCompanyById(id);
        return new ResponseEntity<>(company, HttpStatusCode.valueOf(200));
    }

    // Retrieve all companies
    @GetMapping("/companyall")
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return new ResponseEntity<>(companies, HttpStatusCode.valueOf(200));
    }
   
}
