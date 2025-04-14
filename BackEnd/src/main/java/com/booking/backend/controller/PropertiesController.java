package com.booking.backend.controller;

import com.booking.backend.dto.PropertiesDTO;
import com.booking.backend.service.PropertiesService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertiesController {

    @Autowired
    private PropertiesService propertiesService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllProperties() {
        List<PropertiesDTO> properties = propertiesService.getAllProperties(); // ensure you implement this method
        return ResponseEntity.ok(properties);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProperty(
            @RequestParam("type") String type,
            @RequestParam("name") String name,
            @RequestParam("country") String country,
            @RequestParam("city") String city,
            @RequestParam("address") String address,
            @RequestParam("description") String description,
            @RequestParam("bedCount") int bedCount,
            @RequestParam("price") double price,
            @RequestParam("image") MultipartFile imageFile,
            HttpServletRequest request) {

        PropertiesDTO propertiesDTO = new PropertiesDTO();
        propertiesDTO.setType(type);
        propertiesDTO.setName(name);
        propertiesDTO.setCountry(country);
        propertiesDTO.setCity(city);
        propertiesDTO.setAddress(address);
        propertiesDTO.setDescription(description);
        propertiesDTO.setBedCount(bedCount);
        propertiesDTO.setPrice(price);

        // Retrieve the email set by the JwtFilter (or via SecurityContextHolder)
        String email = (String) request.getAttribute("email");
        propertiesDTO.setUserEmail(email);

        PropertiesDTO savedProperty = propertiesService.saveProperty(propertiesDTO, imageFile);
        return ResponseEntity.ok(savedProperty);
    }

    // New endpoint to get properties for the logged-in user
    @GetMapping("/user")
    public ResponseEntity<?> getUserProperties(HttpServletRequest request) {
        // Retrieve the email from the request attribute
        String email = (String) request.getAttribute("email");
        if (email == null) {
            return ResponseEntity.status(401).body("Unauthorized");
        }

        List<PropertiesDTO> userProperties = propertiesService.getPropertiesByUser(email);
        return ResponseEntity.ok(userProperties);
    }
}
