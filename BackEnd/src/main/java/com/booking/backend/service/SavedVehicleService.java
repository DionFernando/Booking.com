package com.booking.backend.service;

import com.booking.backend.entity.SavedVehicle;
import com.booking.backend.entity.Vehicle;
import com.booking.backend.repo.SavedVehicleRepository;
import com.booking.backend.repo.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SavedVehicleService {

    private final SavedVehicleRepository savedVehicleRepository;
    private final VehicleRepository vehicleRepository;

    public SavedVehicleService(SavedVehicleRepository savedVehicleRepository, VehicleRepository vehicleRepository) {
        this.savedVehicleRepository = savedVehicleRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public SavedVehicle saveVehicle(String userId, UUID vehicleId) {
        // Check if the vehicle is already saved by the user
        Optional<SavedVehicle> existing = savedVehicleRepository.findByUserIdAndVehicle_Id(userId, vehicleId);
        if (existing.isPresent()) {
            return existing.get();
        }
        // Retrieve the vehicle from the repository
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        SavedVehicle savedVehicle = new SavedVehicle();
        savedVehicle.setUserId(userId);
        savedVehicle.setVehicle(vehicle);
        return savedVehicleRepository.save(savedVehicle);
    }
}
