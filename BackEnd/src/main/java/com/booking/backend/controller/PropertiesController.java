package com.booking.backend.controller;

import com.booking.backend.dto.PropertiesDTO;
import com.booking.backend.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertiesController {

    @Autowired
    private PropertiesService propertiesService;

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
            @RequestParam("image") MultipartFile imageFile) {

        PropertiesDTO propertiesDTO = new PropertiesDTO();
        propertiesDTO.setType(type);
        propertiesDTO.setName(name);
        propertiesDTO.setCountry(country);
        propertiesDTO.setCity(city);
        propertiesDTO.setAddress(address);
        propertiesDTO.setDescription(description);
        propertiesDTO.setBedCount(bedCount);
        propertiesDTO.setPrice(price);

        PropertiesDTO savedProperty = propertiesService.saveProperty(propertiesDTO, imageFile);
        return ResponseEntity.ok(savedProperty);
    }
}
