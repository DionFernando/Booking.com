/*
package com.booking.backend.controller;

import com.booking.backend.dto.SavedVehicleDTO;
import com.booking.backend.entity.SavedVehicle;
import com.booking.backend.service.SavedVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/saved-vehicles")
public class SavedVehicleController {

    private final SavedVehicleService savedVehicleService;

    public SavedVehicleController(SavedVehicleService savedVehicleService) {
        this.savedVehicleService = savedVehicleService;
    }

    @PostMapping
    public ResponseEntity<?> saveVehicle(@RequestBody SavedVehicleDTO request) {
        SavedVehicle savedVehicle = savedVehicleService.saveVehicle(request.getUserId(), request.getVehicleId());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicle);
    }
}
*/
