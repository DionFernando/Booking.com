package com.booking.backend.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class SavedVehicleDTO {
    private String userId;
    private UUID vehicleId;
}
