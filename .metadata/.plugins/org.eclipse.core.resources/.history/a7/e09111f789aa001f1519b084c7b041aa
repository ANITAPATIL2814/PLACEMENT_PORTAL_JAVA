package com.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// Represents the PlacementDrive entity
@Entity
@Getter // Generates all getter methods
@Setter // Generates all setter methods
public class PlacementDrive {

    @Id // Specifies the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key value
    private Long PlacementDriveId;

    private LocalDateTime driveDate;

    private int numberOfVacancies;

    @Column(length = 20) // Defines the column length for status
    private String status; // E.g., "Upcoming", "Completed"

    @ManyToOne // Specifies the relationship with the Company entity
    private Company company;
}
