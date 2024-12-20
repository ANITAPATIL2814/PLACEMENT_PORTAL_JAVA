package com.demo.serviceimpl;

import com.demo.entity.PlacementDrive;
import com.demo.exception.PlacementDriveNotFoundException;
import com.demo.repository.PlacementDriveRepository;
import com.demo.service.PlacementDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marks this class as a Spring bean
public class PlacementDriveServiceImpl implements PlacementDriveService {

    @Autowired
    private PlacementDriveRepository placementDriveRepository;

    @Override
    public PlacementDrive addPlacementDrive(PlacementDrive placementDrive) {
        return placementDriveRepository.save(placementDrive);
    }

    @Override
    public PlacementDrive getPlacementDriveById(Long id) throws PlacementDriveNotFoundException {
        return placementDriveRepository.findById(id)
                .orElseThrow(() -> new PlacementDriveNotFoundException("Placement Drive not found with ID: " + id));
    }

    @Override
    public List<PlacementDrive> getAllPlacementDrives() {
        return placementDriveRepository.findAll();
    }

    @Override
    public PlacementDrive updatePlacementDrive(Long id, PlacementDrive placementDrive) throws PlacementDriveNotFoundException {
        PlacementDrive existingDrive = getPlacementDriveById(id);
        existingDrive.setDriveDate(placementDrive.getDriveDate());
        existingDrive.setNumberOfVacancies(placementDrive.getNumberOfVacancies());
        existingDrive.setStatus(placementDrive.getStatus());
        existingDrive.setCompany(placementDrive.getCompany());
        return placementDriveRepository.save(existingDrive);
    }

   
      @Override
    public void deletePlacementDrive(Long id) throws PlacementDriveNotFoundException {
        PlacementDrive placementDrive = getPlacementDriveById(id);
        placementDriveRepository.delete(placementDrive);
    }

 
    
}
