package com.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// Represents the JobPosting entity
@Entity
@Getter // Generates all getter methods
@Setter // Generates all setter methods
public class JobPosting {

    @Id // Specifies the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key value
    private Long jobId;

    @Column(length = 50, nullable = false) // Defines the column length and non-null constraint
    private String JobTitle;

    @Column(length = 255) // Defines the column length
    private String JobDescription;

    @Column(length = 100) // Defines the column length
    private String SkillsRequired;

    private double JobSalary;

    @Column(length = 100) // Defines the column length
    @Size(max = 100, message = "Location must be less than 100 characters")
    private String JobLocation;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
