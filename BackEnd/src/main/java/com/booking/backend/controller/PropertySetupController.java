package com.booking.backend.controller;

import com.booking.backend.service.PropertySetupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/properties")
public class PropertySetupController {

    private final PropertySetupService propertySetupService;

    public PropertySetupController(PropertySetupService propertySetupService) {
        this.propertySetupService = propertySetupService;
    }

    @PostMapping("/{propertyId}/upload-images")
    public ResponseEntity<String> uploadImages(@PathVariable UUID propertyId, @RequestParam("images") List<MultipartFile> images) {
        try {
            String response = propertySetupService.uploadImages(propertyId, images);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error uploading images!");
        }
    }
}
