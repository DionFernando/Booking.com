package com.booking.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyDTO {
    private UUID id;
    private String type;
    private String name;
    private String country;
    private String city;
    private String address;
    private String description;
}
