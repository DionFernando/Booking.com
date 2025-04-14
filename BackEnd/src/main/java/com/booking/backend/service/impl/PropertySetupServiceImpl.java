/*
package com.booking.backend.service.impl;

import com.booking.backend.entity.PropertyImage;
import com.booking.backend.entity.PropertySetup;
import com.booking.backend.repo.PropertyImageRepository;
import com.booking.backend.repo.PropertySetupRepository;
import com.booking.backend.service.PropertySetupService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PropertySetupServiceImpl implements PropertySetupService {

    private final PropertySetupRepository propertySetupRepository;
    private final PropertyImageRepository propertyImageRepository;

    public PropertySetupServiceImpl(PropertySetupRepository propertySetupRepository, PropertyImageRepository propertyImageRepository) {
        this.propertySetupRepository = propertySetupRepository;
        this.propertyImageRepository = propertyImageRepository;
    }

    @Override
    public String uploadImages(UUID propertyId, List<MultipartFile> images) throws IOException {
        Optional<PropertySetup> propertySetupOptional = propertySetupRepository.findById(propertyId);
        if (propertySetupOptional.isEmpty()) {
            return "Property not found!";
        }
        PropertySetup propertySetup = propertySetupOptional.get();

        if (images.size() < 3 || images.size() > 20) {
            return "You must upload between 3 to 20 images!";
        }

        for (MultipartFile image : images) {
            PropertyImage propertyImage = new PropertyImage();
            propertyImage.setImageData(image.getBytes());
            propertyImage.setPropertySetup(propertySetup);
            propertyImageRepository.save(propertyImage);
        }

        return "Images uploaded successfully!";
    }
}
*/
