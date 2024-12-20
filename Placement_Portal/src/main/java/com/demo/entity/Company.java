package com.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import com.demo.validation.ValidPhoneNumber;
import com.fasterxml.jackson.annotation.JsonBackReference;

// Represents the Company entity in the database
@Entity
@Getter // Lombok annotation to generate getter methods automatically
@Setter // Lombok annotation to generate setter methods automatically
public class Company {

    @Id // Specifies this field as the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the ID is auto-generated
    private Long CompanyId;

    // Validates that the company name is not blank and is mandatory
    @NotBlank(message = "Company name is mandatory")
    @Column(length = 100, nullable = false) // Ensures the column length and non-null constraint
    private String companyName;

    // Validates that the company email is not blank, must be a valid email format, and is unique
    @NotBlank(message = "Company email is mandatory")
    @Email(message = "Company email is invalid, enter a proper email") // Validates email format
    @Column(length = 50, nullable = false, unique = true) // Ensures unique email and column length constraint
    private String CompanyEmail;

    // Validates the contact number for the company
    @NotBlank(message="Company contact Number is mandatory")
    @Column(length = 11, nullable = false, unique=true) // Ensures contact number is unique and non-null
    @ValidPhoneNumber(message="Phone number should be exactly 10 digits & Start with 6/7/8/9") // Custom phone validation
    private String CompanyPhone;

    // Defines a one-to-many relationship with the JobPosting entity (mapped by 'company' in JobPosting)
    @OneToMany(mappedBy = "company")
    @JsonBackReference // Prevent circular serialization
    private List<JobPosting> jobPostings;
}
