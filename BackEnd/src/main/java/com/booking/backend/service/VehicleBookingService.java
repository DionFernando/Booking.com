package com.booking.backend.service;

import com.booking.backend.dto.VehicleBookingDTO;

import java.util.List;
import java.util.UUID;

public interface VehicleBookingService {
    VehicleBookingDTO bookVehicle(VehicleBookingDTO bookingDTO);
    void cancelBooking(UUID bookingId);
    List<VehicleBookingDTO> getAllBookings();
}
