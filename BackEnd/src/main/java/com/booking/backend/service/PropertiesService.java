package com.booking.backend.service;

import com.booking.backend.dto.PropertiesDTO;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface PropertiesService {
    PropertiesDTO saveProperty(PropertiesDTO propertiesDTO, MultipartFile imageFile);

    // New method to get properties for a given user email
    List<PropertiesDTO> getPropertiesByUser(String email);
}
