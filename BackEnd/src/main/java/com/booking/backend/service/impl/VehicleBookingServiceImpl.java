package com.booking.backend.service.impl;

import com.booking.backend.dto.VehicleBookingDTO;
import com.booking.backend.entity.Vehicle;
import com.booking.backend.entity.VehicleBooking;
import com.booking.backend.repo.VehicleBookingRepository;
import com.booking.backend.repo.VehicleRepository;
import com.booking.backend.service.VehicleBookingService;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class VehicleBookingServiceImpl implements VehicleBookingService {

    private final VehicleBookingRepository bookingRepository;
    private final VehicleRepository vehicleRepository;

    public VehicleBookingServiceImpl(VehicleBookingRepository bookingRepository, VehicleRepository vehicleRepository) {
        this.bookingRepository = bookingRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleBookingDTO bookVehicle(VehicleBookingDTO bookingDTO) {
        // Verify the vehicle exists.
        Vehicle vehicle = vehicleRepository.findById(bookingDTO.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found!"));

        // Calculate the booking duration.
        long days = ChronoUnit.DAYS.between(bookingDTO.getStartDate(), bookingDTO.getEndDate());
        if (days < 3) {
            throw new RuntimeException("Booking must be for at least 3 days.");
        }

        // Check for overlapping bookings.
        List<VehicleBooking> overlappingBookings = bookingRepository.findOverlappingBookings(
                vehicle.getId(), bookingDTO.getStartDate(), bookingDTO.getEndDate());
        if (!overlappingBookings.isEmpty()) {
            throw new RuntimeException("Vehicle is already booked for the selected date range.");
        }

        // Create and save the booking, setting the price from the DTO.
        VehicleBooking booking = new VehicleBooking();
        booking.setVehicle(vehicle);
        booking.setUserId(bookingDTO.getUserId());
        booking.setStartDate(bookingDTO.getStartDate());
        booking.setEndDate(bookingDTO.getEndDate());
        booking.setPrice(bookingDTO.getPrice()); // Set the price here

        booking = bookingRepository.save(booking);

        return convertToDTO(booking);
    }

    @Override
    public void cancelBooking(UUID bookingId) {
        VehicleBooking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found!"));
        bookingRepository.delete(booking);
    }

    @Override
    public List<VehicleBookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private VehicleBookingDTO convertToDTO(VehicleBooking booking) {
        return new VehicleBookingDTO(
                booking.getId(),
                booking.getVehicle().getId(),
                booking.getUserId(),
                booking.getStartDate(),
                booking.getEndDate(),
                booking.getPrice() // Include the price in the DTO
        );
    }
}
