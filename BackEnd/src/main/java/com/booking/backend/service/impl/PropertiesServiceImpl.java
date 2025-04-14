package com.booking.backend.service.impl;

import com.booking.backend.dto.PropertiesDTO;
import com.booking.backend.entity.Properties;
import com.booking.backend.repo.PropertiesRepository;
import com.booking.backend.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
            if (imageFile != null && !imageFile.isEmpty()) {
                property.setImage(imageFile.getBytes());
            }
            Properties saved = propertiesRepository.save(property);
            // Optionally convert saved entity to DTO (if needed)
            return propertiesDTO;
        } catch (Exception e) {
            // log and rethrow as needed
            throw new RuntimeException("Failed to save property", e);
        }
    }
}
