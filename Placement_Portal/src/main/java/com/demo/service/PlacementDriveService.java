package com.demo.service;

import com.demo.entity.PlacementDrive;
import com.demo.exception.PlacementDriveNotFoundException;

import java.util.List;

public interface PlacementDriveService {
    PlacementDrive addPlacementDrive(PlacementDrive placementDrive);

    PlacementDrive getPlacementDriveById(Long id) throws PlacementDriveNotFoundException;

    List<PlacementDrive> getAllPlacementDrives();

    PlacementDrive updatePlacementDrive(Long id, PlacementDrive placementDrive) throws PlacementDriveNotFoundException;

    void deletePlacementDrive(Long id) throws PlacementDriveNotFoundException;
}
