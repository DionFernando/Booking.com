package com.booking.backend.controller;

import com.booking.backend.dto.VehicleDTO;
import com.booking.backend.service.VehicleService;
import com.booking.backend.util.JwtUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.UUID;

//@CrossOrigin(origins = "http://localhost:63342")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vehicles")

public class VehicleController {

    private final VehicleService vehicleService;
    private final JwtUtil jwtUtil;

    public VehicleController(VehicleService vehicleService, JwtUtil jwtUtil) {
        this.vehicleService = vehicleService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/save")
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO, HttpServletRequest request) {
//        String email = (String) request.getAttribute("email");
        var email = jwtUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
        // Optionally check if email is null and handle unauthorized access
        if (email == null) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(vehicleService.createVehicle(vehicleDTO, email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable UUID id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable UUID id, @RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicleDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable UUID id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok("Vehicle deleted successfully!");
    }
}
