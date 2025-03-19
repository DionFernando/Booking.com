package com.booking.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
    private UUID id;
    private String type;
    private String brand;
    private Integer seats;
    private String color;
    private String description;
    private String image;
    private Double priceFor3Days;
}
