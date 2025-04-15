package com.booking.backend.controller;

import com.booking.backend.dto.PropertyBookingDTO;
import com.booking.backend.entity.PropertyBooking;
import com.booking.backend.service.PropertyBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/bookings")
public class PropertyBookingController {

    @Autowired
    private PropertyBookingService bookingService;

    @PostMapping("/save")
    public ResponseEntity<PropertyBooking> saveBooking(@RequestBody PropertyBookingDTO bookingDTO) {
        // Optionally, check again on the server side for overlapping bookings.
        if (!bookingService.isPropertyAvailable(bookingDTO.getPropertyId(), bookingDTO.getStartDate(), bookingDTO.getEndDate())) {
            return ResponseEntity.badRequest().build();
        }
        PropertyBooking savedBooking = bookingService.saveBooking(bookingDTO);
        return ResponseEntity.ok(savedBooking);
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkBookingAvailability(
            @RequestParam Long propertyId,
            @RequestParam String startDate,
            @RequestParam String endDate) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        boolean available = bookingService.isPropertyAvailable(propertyId, start, end);
        // Returns true if the property is available (i.e. no booking conflicts), false otherwise.
        return ResponseEntity.ok(available);
    }
}
