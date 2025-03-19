package com.booking.backend.controller;

import com.booking.backend.dto.VehicleBookingDTO;
import com.booking.backend.service.VehicleBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vehicle-bookings")
public class VehicleBookingController {

    private final VehicleBookingService bookingService;

    public VehicleBookingController(VehicleBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public ResponseEntity<VehicleBookingDTO> bookVehicle(@RequestBody VehicleBookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.bookVehicle(bookingDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable UUID id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.ok("Booking cancelled successfully!");
    }

    @GetMapping
    public ResponseEntity<List<VehicleBookingDTO>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
}
