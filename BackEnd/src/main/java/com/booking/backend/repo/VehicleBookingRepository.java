package com.booking.backend.repo;

import com.booking.backend.entity.VehicleBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface VehicleBookingRepository extends JpaRepository<VehicleBooking, UUID> {

    @Query("SELECT b FROM VehicleBooking b WHERE b.vehicle.id = :vehicleId " +
            "AND b.startDate <= :endDate AND b.endDate >= :startDate")
    List<VehicleBooking> findOverlappingBookings(@Param("vehicleId") UUID vehicleId,
                                                 @Param("startDate") LocalDate startDate,
                                                 @Param("endDate") LocalDate endDate);
}
