package com.booking.backend.service;

import com.booking.backend.dto.PropertyBookingDTO;
import com.booking.backend.entity.PropertyBooking;
import java.time.LocalDate;

public interface PropertyBookingService {
    PropertyBooking saveBooking(PropertyBookingDTO bookingDTO);
    // Returns true if the property is available, false if not.
    boolean isPropertyAvailable(Long propertyId, LocalDate startDate, LocalDate endDate);
}
