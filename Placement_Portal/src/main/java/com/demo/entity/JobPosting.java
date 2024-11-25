package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// Represents the JobPosting entity in the database
@Entity
@Getter // Lombok annotation to generate getter methods automatically
@Setter // Lombok annotation to generate setter methods automatically
public class JobPosting {

    @Id // Specifies this field as the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the ID is auto-generated
    private Long jobId;

    @Column(length = 50, nullable = false) // Ensures the job name column is non-null with the specified length
    private String jobName;

    @Column(length = 255) // Defines the column length for job description
    private String jobDescription;

    @Column(length = 100) // Defines the column length for required skills
    private String skillsRequired;

    private double jobSalary; // Stores the job's salary (no length constraint needed for numerical value)

    @Column(length = 100) // Ensures location is specified and has a length constraint
    @Size(max = 100, message = "Location must be less than 100 characters") // Ensures the location doesn't exceed 100 characters
    private String jobLocation;

    // Establishes a many-to-one relationship with the Company entity (many JobPostings can belong to one Company)
    @ManyToOne
    @JsonIgnore // Ignore the reference while serializing
    @JoinColumn(name = "company_id", nullable = false) // Specifies the foreign key column name and enforces it as non-null
    private Company company;
}
