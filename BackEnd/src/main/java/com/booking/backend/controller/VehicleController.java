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
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private final JwtUtil jwtUtil;

    // Target folder where images will be stored
    private final String imageUploadDir = "/home/dion/Desktop/images";

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
            // Convert uploaded file to Base64 string
            byte[] fileBytes = file.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(fileBytes);
            // Set the image string with proper data URL prefix (adjust MIME type if necessary)
            vehicleDTO.setImage("data:" + file.getContentType() + ";base64," + base64Image);

            // Now create the vehicle with the encoded image
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
