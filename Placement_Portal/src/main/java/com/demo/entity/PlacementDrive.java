package com.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// Represents the PlacementDrive entity in the database
@Entity
@Getter // Lombok annotation to generate getter methods automatically
@Setter // Lombok annotation to generate setter methods automatically
public class PlacementDrive {

    @Id // Specifies this field as the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the ID is auto-generated
    private Long PlacementDriveId;

    private LocalDateTime driveDate; // Stores the date and time of the placement drive

    private int numberOfVacancies; // Stores the number of job vacancies for the drive

    @Column(length = 20) // Defines the column length for the status field
    private String status; // Represents the status of the placement drive (e.g., "Upcoming", "Completed")

    // Establishes a many-to-one relationship with the Company entity (each PlacementDrive is associated with one Company)
    @ManyToOne
    private Company company;
}
