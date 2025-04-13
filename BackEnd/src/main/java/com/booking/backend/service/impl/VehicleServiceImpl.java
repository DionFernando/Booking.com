package com.booking.backend.service.impl;

import com.booking.backend.dto.VehicleDTO;
import com.booking.backend.entity.Vehicle;
import com.booking.backend.repo.VehicleRepository;
import com.booking.backend.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO, String ownerEmail) {
        Vehicle vehicle = new Vehicle(
                null,
                vehicleDTO.getType(),
                vehicleDTO.getBrand(),
                vehicleDTO.getSeats(),
                vehicleDTO.getColor(),
                vehicleDTO.getDescription(),
                vehicleDTO.getImage(),
                vehicleDTO.getPriceFor3Days(),
                ownerEmail  // Set the owner email from the token
        );
        vehicle = vehicleRepository.save(vehicle);
        return convertToDTO(vehicle);
    }

    // Other methods remain unchanged…

    @Override
    public List<VehicleDTO> getVehiclesByOwner(String ownerEmail) {
        return vehicleRepository.findByOwnerEmail(ownerEmail)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO getVehicleById(UUID id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found!"));
        return convertToDTO(vehicle);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO updateVehicle(UUID id, VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found!"));
        vehicle.setType(vehicleDTO.getType());
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setSeats(vehicleDTO.getSeats());
        vehicle.setColor(vehicleDTO.getColor());
        vehicle.setDescription(vehicleDTO.getDescription());
        vehicle.setImage(vehicleDTO.getImage());
        vehicle.setPriceFor3Days(vehicleDTO.getPriceFor3Days());
        vehicle = vehicleRepository.save(vehicle);
        return convertToDTO(vehicle);
    }

    @Override
    public void deleteVehicle(UUID id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found!"));
        vehicleRepository.delete(vehicle);
    }

    private VehicleDTO convertToDTO(Vehicle vehicle) {
        return new VehicleDTO(
                vehicle.getId(),
                vehicle.getType(),
                vehicle.getBrand(),
                vehicle.getSeats(),
                vehicle.getColor(),
                vehicle.getDescription(),
                vehicle.getImage(),
                vehicle.getPriceFor3Days(),
                vehicle.getOwnerEmail()
        );
    }
}
