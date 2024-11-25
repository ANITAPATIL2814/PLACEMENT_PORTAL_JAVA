package com.demo.controller;

import com.demo.entity.PlacementDrive;
import com.demo.exception.PlacementDriveNotFoundException;
import com.demo.service.PlacementDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlacementDriveController {

    @Autowired
    private PlacementDriveService placementDriveService;

    // Add a new placement drive
    @PostMapping("/placementdrive/add")
    public ResponseEntity<PlacementDrive> addPlacementDrive(@RequestBody PlacementDrive placementDrive) {
        PlacementDrive createdDrive = placementDriveService.addPlacementDrive(placementDrive);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDrive);
    }

    // Retrieve a placement drive by ID
    @GetMapping("/placementdrive/{id}")
    public ResponseEntity<PlacementDrive> getPlacementDriveById(@PathVariable Long id) {
        try {
            PlacementDrive placementDrive = placementDriveService.getPlacementDriveById(id);
            return ResponseEntity.ok(placementDrive);
        } catch (PlacementDriveNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Retrieve all placement drives
    @GetMapping("/placementdrive/all")
    public ResponseEntity<List<PlacementDrive>> getAllPlacementDrives() {
        List<PlacementDrive> placementDrives = placementDriveService.getAllPlacementDrives();
        return ResponseEntity.ok(placementDrives);
    }
    
/*
    // Update a placement drive
    @PutMapping("/placementdrive/update/{id}")
    public ResponseEntity<PlacementDrive> updatePlacementDrive(
            @PathVariable Long id,
            @RequestBody PlacementDrive placementDrive) {
        try {
            PlacementDrive updatedDrive = placementDriveService.updatePlacementDrive(id, placementDrive);
            return ResponseEntity.ok(updatedDrive);
        } catch (PlacementDriveNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Delete a placement drive by ID
    @DeleteMapping("/placementdrive/delete/{id}")
    public ResponseEntity<String> deletePlacementDrive(@PathVariable Long id) {
        try {
            placementDriveService.deletePlacementDrive(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Placement drive deleted successfully.");
        } catch (PlacementDriveNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Placement drive not found.");
        }
    } */
}
