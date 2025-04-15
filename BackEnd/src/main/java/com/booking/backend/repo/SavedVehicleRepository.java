package com.booking.backend.repo;

import com.booking.backend.entity.SavedVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SavedVehicleRepository extends JpaRepository<SavedVehicle, UUID> {
    Optional<SavedVehicle> findByUserIdAndVehicle_Id(String userId, UUID vehicleId);
}
