package com.booking.backend.service;

import com.booking.backend.dto.VehicleDTO;
import java.util.List;
import java.util.UUID;

public interface VehicleService {
    VehicleDTO createVehicle(VehicleDTO vehicleDTO, String ownerEmail);
    VehicleDTO getVehicleById(UUID id);
    List<VehicleDTO> getAllVehicles();
    VehicleDTO updateVehicle(UUID id, VehicleDTO vehicleDTO);
    void deleteVehicle(UUID id);

    List<VehicleDTO> getVehiclesByOwner(String ownerEmail);
}

