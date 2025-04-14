package com.booking.backend.service.impl;

import com.booking.backend.dto.PropertiesDTO;
import com.booking.backend.entity.Properties;
import com.booking.backend.repo.PropertiesRepository;
import com.booking.backend.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertiesServiceImpl implements PropertiesService {

    @Autowired
    private PropertiesRepository propertiesRepository;

    @Override
    public PropertiesDTO saveProperty(PropertiesDTO propertiesDTO, MultipartFile imageFile) {
        try {
            Properties property = new Properties();
            property.setType(propertiesDTO.getType());
            property.setName(propertiesDTO.getName());
            property.setCountry(propertiesDTO.getCountry());
            property.setCity(propertiesDTO.getCity());
            property.setAddress(propertiesDTO.getAddress());
            property.setDescription(propertiesDTO.getDescription());
            property.setBedCount(propertiesDTO.getBedCount());
            property.setPrice(propertiesDTO.getPrice());
            property.setUserEmail(propertiesDTO.getUserEmail()); // Save the user's email

            if (imageFile != null && !imageFile.isEmpty()) {
                property.setImage(imageFile.getBytes());
            }
            Properties saved = propertiesRepository.save(property);
            // Optionally, map saved to a new DTO for response
            return propertiesDTO;
        } catch (Exception e) {
            throw new RuntimeException("Failed to save property", e);
        }
    }

    @Override
    public List<PropertiesDTO> getPropertiesByUser(String email) {
        List<Properties> propertiesList = propertiesRepository.findByUserEmail(email);
        // Map entity list to DTO list (manual mapping below):
        return propertiesList.stream().map(property -> {
            PropertiesDTO dto = new PropertiesDTO();
            dto.setType(property.getType());
            dto.setName(property.getName());
            dto.setCountry(property.getCountry());
            dto.setCity(property.getCity());
            dto.setAddress(property.getAddress());
            dto.setDescription(property.getDescription());
            dto.setBedCount(property.getBedCount());
            dto.setPrice(property.getPrice());
            dto.setUserEmail(property.getUserEmail());
            // Omit image mapping if not needed or handle as required.
            return dto;
        }).collect(Collectors.toList());
    }
}
