/*
package com.booking.backend.controller;

import com.booking.backend.dto.VehicleBookingDTO;
import com.booking.backend.service.UserVehicleBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user-vehicle-bookings")
public class UserVehicleBookingController {

    private final UserVehicleBookingService userBookingService;

    public UserVehicleBookingController(UserVehicleBookingService userBookingService) {
        this.userBookingService = userBookingService;
    }

    // Endpoint to get current/upcoming bookings for a user
    @GetMapping("/current/{userId}")
    public ResponseEntity<List<VehicleBookingDTO>> getCurrentBookings(@PathVariable String userId) {
        return ResponseEntity.ok(userBookingService.getCurrentBookings(userId));
    }

    // Endpoint to get past bookings for a user
    @GetMapping("/past/{userId}")
    public ResponseEntity<List<VehicleBookingDTO>> getPastBookings(@PathVariable String userId) {
        return ResponseEntity.ok(userBookingService.getPastBookings(userId));
    }

    // Endpoint for a user to cancel a booking they own
    @DeleteMapping("/{userId}/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable String userId, @PathVariable UUID bookingId) {
        userBookingService.cancelBooking(userId, bookingId);
        return ResponseEntity.ok("Booking cancelled successfully.");
    }
}
*/
