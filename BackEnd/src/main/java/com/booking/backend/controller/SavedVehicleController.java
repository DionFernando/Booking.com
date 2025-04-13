/*
package com.booking.backend.controller;

import com.booking.backend.dto.VehicleDTO;
import com.booking.backend.service.SavedVehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/saved-vehicles")
public class SavedVehicleController {

    private final SavedVehicleService savedVehicleService;

    public SavedVehicleController(SavedVehicleService savedVehicleService) {
        this.savedVehicleService = savedVehicleService;
    }

    // Save a vehicle (clicking the heart icon)
    @PostMapping("/{userId}/{vehicleId}")
    public ResponseEntity<String> saveVehicle(@PathVariable String userId, @PathVariable UUID vehicleId) {
        savedVehicleService.saveVehicle(userId, vehicleId);
        return ResponseEntity.ok("Vehicle saved successfully.");
    }

    // Remove a saved vehicle (clicking the heart icon again)
    @DeleteMapping("/{userId}/{vehicleId}")
    public ResponseEntity<String> removeSavedVehicle(@PathVariable String userId, @PathVariable UUID vehicleId) {
        savedVehicleService.removeSavedVehicle(userId, vehicleId);
        return ResponseEntity.ok("Vehicle removed from saved list.");
    }

    // Get saved vehicles for a user
    @GetMapping("/{userId}")
    public ResponseEntity<List<VehicleDTO>> getSavedVehicles(@PathVariable String userId) {
        return ResponseEntity.ok(savedVehicleService.getSavedVehicles(userId));
    }
}
*/
