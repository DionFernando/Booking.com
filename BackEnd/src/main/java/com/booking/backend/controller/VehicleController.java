/*
package com.booking.backend.controller;

import com.booking.backend.dto.VehicleDTO;
import com.booking.backend.service.VehicleService;
import com.booking.backend.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

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
        String email = jwtUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
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

    // New endpoint: Get vehicles for the current user
    @GetMapping("/user")
    public ResponseEntity<List<VehicleDTO>> getVehiclesForUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(401).build();
        }
        String email = jwtUtil.getUsernameFromToken(token.substring(7));
        List<VehicleDTO> vehicles = vehicleService.getVehiclesByOwner(email);
        return ResponseEntity.ok(vehicles);
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
*/

package com.booking.backend.controller;

import com.booking.backend.dto.VehicleDTO;
import com.booking.backend.service.VehicleService;
import com.booking.backend.util.JwtUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private final JwtUtil jwtUtil;

    // Target folder where images will be stored
    private final String imageUploadDir = "/home/dion/Documents/GDSE69/10. AAD/Final CourseWork/Images";

    public VehicleController(VehicleService vehicleService, JwtUtil jwtUtil) {
        this.vehicleService = vehicleService;
        this.jwtUtil = jwtUtil;
    }

    // New endpoint to handle multipart/form-data file upload
    @PostMapping(value="/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<VehicleDTO> createVehicle(
            @ModelAttribute VehicleDTO vehicleDTO,
            @RequestParam("imageFile") MultipartFile file,
            HttpServletRequest request) {

        String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            return ResponseEntity.status(401).build();
        }
        String email = jwtUtil.getUsernameFromToken(authorization.substring(7));
        if (email == null) {
            return ResponseEntity.status(401).build();
        }

        try {
            // Ensure the directory exists
            Path uploadPath = Paths.get(imageUploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            // Create a unique filename (you might use UUID or timestamp)
            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(filename);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Option 1: Store absolute path
            // vehicleDTO.setImage(filePath.toString());

            // Option 2: Store relative URL if you plan to serve from a static file server:
            vehicleDTO.setImage("/images/" + filename);

            VehicleDTO savedVehicle = vehicleService.createVehicle(vehicleDTO, email);
            return ResponseEntity.ok(savedVehicle);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    // Existing endpoints...
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable UUID id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/user")
    public ResponseEntity<List<VehicleDTO>> getVehiclesForUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(401).build();
        }
        String email = jwtUtil.getUsernameFromToken(token.substring(7));
        List<VehicleDTO> vehicles = vehicleService.getVehiclesByOwner(email);
        return ResponseEntity.ok(vehicles);
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
