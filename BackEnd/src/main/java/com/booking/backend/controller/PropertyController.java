/*
package com.booking.backend.controller;

import com.booking.backend.dto.PropertyDTO;
import com.booking.backend.service.PropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/save")
    public ResponseEntity<PropertyDTO> createProperty(@RequestBody PropertyDTO propertyDTO) {
        return ResponseEntity.ok(propertyService.createProperty(propertyDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDTO> getPropertyById(@PathVariable UUID id) {
        return ResponseEntity.ok(propertyService.getPropertyById(id));
    }

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(@PathVariable UUID id, @RequestBody PropertyDTO propertyDTO) {
        return ResponseEntity.ok(propertyService.updateProperty(id, propertyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable UUID id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.ok("Property deleted successfully!");
    }
}
*/
