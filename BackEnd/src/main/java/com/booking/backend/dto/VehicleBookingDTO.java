package com.booking.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleBookingDTO {
    private UUID id;
    private UUID vehicleId;
    private String userId;
    private LocalDate startDate;
    private LocalDate endDate;
}
