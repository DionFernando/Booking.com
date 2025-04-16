/*

package com.booking.backend.service.impl;

import com.booking.backend.dto.VehicleDTO;
import com.booking.backend.entity.SavedVehicle;
import com.booking.backend.entity.Vehicle;
import com.booking.backend.repo.SavedVehicleRepository;
import com.booking.backend.repo.VehicleRepository;
import com.booking.backend.service.SavedVehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SavedVehicleServiceImpl */
/*implements SavedVehicleService*//*
 {
*/
/*
    private final SavedVehicleRepository savedVehicleRepository;
    private final VehicleRepository vehicleRepository;

    public SavedVehicleServiceImpl(SavedVehicleRepository savedVehicleRepository, VehicleRepository vehicleRepository) {
        this.savedVehicleRepository = savedVehicleRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void saveVehicle(String userId, UUID vehicleId) {
        // Check if the vehicle exists
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        // Check if the vehicle is already saved
        if (savedVehicleRepository.findByUserIdAndVehicleId(userId, vehicleId).isPresent()) {
            throw new RuntimeException("Vehicle already saved");
        }

        SavedVehicle savedVehicle = new SavedVehicle();
        savedVehicle.setUserId(userId);
        savedVehicle.setVehicle(vehicle);
        savedVehicleRepository.save(savedVehicle);
    }

    @Override
    public void removeSavedVehicle(String userId, UUID vehicleId) {
        SavedVehicle savedVehicle = savedVehicleRepository.findByUserIdAndVehicleId(userId, vehicleId)
                .orElseThrow(() -> new RuntimeException("Saved vehicle not found"));
        savedVehicleRepository.delete(savedVehicle);
    }

    @Override
    public List<VehicleDTO> getSavedVehicles(String userId) {
        List<SavedVehicle> savedVehicles = savedVehicleRepository.findByUserId(userId);
        return savedVehicles.stream()
                .map(savedVehicle -> new VehicleDTO(
                        savedVehicle.getVehicle().getId(),
                        savedVehicle.getVehicle().getType(),
                        savedVehicle.getVehicle().getBrand(),
                        savedVehicle.getVehicle().getSeats(),
                       savedVehicle.getVehicle().getColor(),
                        savedVehicle.getVehicle().getDescription(),
                        savedVehicle.getVehicle().getImage(),
                        savedVehicle.getVehicle().getPriceFor3Days()
                ))
                .collect(Collectors.toList());
    }*//*

}

*/
