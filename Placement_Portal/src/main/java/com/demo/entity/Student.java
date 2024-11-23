package com.demo.entity;


import com.demo.validation.ValidPhoneNumber;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

// Represents the Student entity
@Entity
@Getter // Generates all getter methods
@Setter // Generates all setter methods
public class Student  {

    @Id // Specifies the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key value
    private int StudId;

    @Column(length = 25, nullable = false) // Defines the column length and non-null constraint
    @NotBlank(message = "Student name is mandatory") // Ensures the name is not blank
    @Size(min = 3, message = "Student name must be 3 or more characters") // Minimum 3 characters
    private String studName;

    @NotBlank(message = "Student email is mandatory") // Ensures the email is not blank
    @Email(message = "Student email is invalid, enter a proper email") // Validates the email format
    @Column(length = 50, nullable = false, unique = true) // Sets the column length, non-null, and unique constraint
    private String StudEmail;
    
    @NotBlank(message="Student contact Number is mandatory")//to ensure char given in contactNumber
	@Column(length = 11, nullable = false, unique=true) 
	@ValidPhoneNumber(message="Phone number should be exactly 10 digits & Start with 6/7/8/9")
    private String phone;
    
    private String skills;
    
    @NotBlank(message="Student address is mandatory")//to ensure char given in address
	@Column(length = 50, nullable = false) 
	private String StudAddress;
    
    @Column(length = 30) // Specifies the column length
    private String StudCourse;

    @Column(length = 10) // Specifies the column length
    private String StudYear;

    private Double StudCgpa;
}
