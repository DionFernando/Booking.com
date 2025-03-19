package com.booking.backend.repo;

import com.booking.backend.entity.SavedVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SavedVehicleRepository extends JpaRepository<SavedVehicle, UUID> {
    List<SavedVehicle> findByUserId(String userId);
    Optional<SavedVehicle> findByUserIdAndVehicleId(String userId, UUID vehicleId);
}
