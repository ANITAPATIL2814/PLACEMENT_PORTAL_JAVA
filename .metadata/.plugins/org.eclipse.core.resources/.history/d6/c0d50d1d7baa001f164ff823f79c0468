package com.demo.controller;

import com.demo.entity.Company;
import com.demo.exception.CompanyNotFoundException;
import com.demo.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // Add a new company
    @PostMapping("/addcompany")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        Company createdCompany = companyService.addCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompany);
    }

    // Retrieve a company by ID
    @GetMapping("/companybyid/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) throws CompanyNotFoundException {
        Company company = companyService.getCompanyById(companyId);
        return ResponseEntity.ok(company);
    }

    // Retrieve all companies
    @GetMapping("/allcompanies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    // Update a company's details
    @PutMapping("/updatecompany/{companyId}")
    public ResponseEntity<Company> updateCompany(
            @PathVariable Long companyId, 
            @RequestBody Company companyDetails) {
        try {
            Company updatedCompany = companyService.updateCompany(companyId, companyDetails);
            return ResponseEntity.ok(updatedCompany);
        } catch (CompanyNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
   
    

   
}
