package com.demo.entity;

import com.demo.validation.ValidPhoneNumber;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

// Represents the Student entity in the database
@Entity
@Getter // Lombok annotation to generate getter methods automatically
@Setter // Lombok annotation to generate setter methods automatically
public class Student {

    @Id // Specifies this field as the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the ID is auto-generated
    private int StudId;

    @Column(length = 25, nullable = false) // Ensures the student name is non-null with the specified length
    @NotBlank(message = "Student name is mandatory") // Ensures the name is mandatory
    @Size(min = 3, message = "Student name must be 3 or more characters") // Minimum length constraint for student name
    private String studName;

    @NotBlank(message = "Student email is mandatory") // Ensures the email is not blank
    @Email(message = "Student email is invalid, enter a proper email") // Validates email format
    @Column(length = 50, nullable = false, unique = true) // Ensures unique email and non-null constraint
    private String StudEmail;

    @NotBlank(message="Student contact Number is mandatory") // Ensures phone number is mandatory
    @Column(length = 11, nullable = true, unique=true)  // Column definition for phone number (nullable and unique)
    @ValidPhoneNumber(message="Phone number should be exactly 10 digits & Start with 6/7/8/9") // Custom validation for phone number
    private String Studphone;

    private String skills; // Stores skills as a string (can be modified to a more structured format)

    @NotBlank(message="Student address is mandatory") // Ensures address is mandatory
    @Column(length = 50, nullable = false) // Ensures address is non-null with the specified length
    private String StudAddress;

    @Column(length = 30) // Defines the column length for course name
    private String StudCourse;

    @Column(length = 10) // Defines the column length for the student year (e.g., "2024")
    private String StudYear;

    private Double studCgpa; // Stores the student's CGPA (nullable if not provided)
}
