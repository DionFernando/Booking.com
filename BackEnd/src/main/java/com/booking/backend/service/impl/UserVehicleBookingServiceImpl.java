/*
package com.booking.backend.service.impl;

import com.booking.backend.dto.VehicleBookingDTO;
import com.booking.backend.entity.VehicleBooking;
import com.booking.backend.repo.UserVehicleBookingRepository;
import com.booking.backend.service.UserVehicleBookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserVehicleBookingServiceImpl implements UserVehicleBookingService {

    private final UserVehicleBookingRepository bookingRepository;

    public UserVehicleBookingServiceImpl(UserVehicleBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<VehicleBookingDTO> getCurrentBookings(String userId) {
        LocalDate today = LocalDate.now();
        List<VehicleBooking> bookings = bookingRepository.findByUserId(userId);
        // Current/upcoming: bookings whose endDate is today or in the future.
        return bookings.stream()
                .filter(b -> !b.getEndDate().isBefore(today))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleBookingDTO> getPastBookings(String userId) {
        LocalDate today = LocalDate.now();
        List<VehicleBooking> bookings = bookingRepository.findByUserId(userId);
        // Past: bookings whose endDate is before today.
        return bookings.stream()
                .filter(b -> b.getEndDate().isBefore(today))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void cancelBooking(String userId, UUID bookingId) {
        // Ensure that the booking exists and belongs to the user.
        VehicleBooking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        if (!booking.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized cancellation attempt");
        }
        bookingRepository.delete(booking);
    }

    private VehicleBookingDTO convertToDTO(VehicleBooking booking) {
        return new VehicleBookingDTO(
                booking.getId(),
                booking.getVehicle().getId(),
                booking.getUserId(),
                booking.getStartDate(),
                booking.getEndDate()
        );
    }
}
*/
public class UserVehicleBookingServiceImpl  {}