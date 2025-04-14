/*
package com.booking.backend.service.impl;

import com.booking.backend.dto.PropertyDTO;
import com.booking.backend.entity.Property;
import com.booking.backend.repo.PropertyRepository;
import com.booking.backend.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public PropertyDTO createProperty(PropertyDTO propertyDTO) {
        Property property = new Property(
                null,
                propertyDTO.getType(),
                propertyDTO.getName(),
                propertyDTO.getCountry(),
                propertyDTO.getCity(),
                propertyDTO.getAddress(),
                propertyDTO.getDescription()
        );
        property = propertyRepository.save(property);
        return convertToDTO(property);
    }

    @Override
    public PropertyDTO getPropertyById(UUID id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found!"));
        return convertToDTO(property);
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        return propertyRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PropertyDTO updateProperty(UUID id, PropertyDTO propertyDTO) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found!"));

        property.setType(propertyDTO.getType());
        property.setName(propertyDTO.getName());
        property.setCountry(propertyDTO.getCountry());
        property.setCity(propertyDTO.getCity());
        property.setAddress(propertyDTO.getAddress());
        property.setDescription(propertyDTO.getDescription());

        property = propertyRepository.save(property);
        return convertToDTO(property);
    }

    @Override
    public void deleteProperty(UUID id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found!"));
        propertyRepository.delete(property);
    }

    private PropertyDTO convertToDTO(Property property) {
        return new PropertyDTO(
                property.getId(),
                property.getType(),
                property.getName(),
                property.getCountry(),
                property.getCity(),
                property.getAddress(),
                property.getDescription()
        );
    }
}
*/
