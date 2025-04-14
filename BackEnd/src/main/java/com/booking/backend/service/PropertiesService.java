package com.booking.backend.service;

import com.booking.backend.dto.PropertiesDTO;
import org.springframework.web.multipart.MultipartFile;

public interface PropertiesService {
    PropertiesDTO saveProperty(PropertiesDTO propertiesDTO, MultipartFile imageFile);
}
