package com.booking.backend.service.impl;

import com.booking.backend.dto.PropertyBookingDTO;
import com.booking.backend.entity.PropertyBooking;
import com.booking.backend.repo.PropertyBookingRepository;
import com.booking.backend.service.PropertyBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PropertyBookingServiceImpl implements PropertyBookingService {

    @Autowired
    private PropertyBookingRepository bookingRepository;

    @Override
    public PropertyBooking saveBooking(PropertyBookingDTO bookingDTO) {
        PropertyBooking booking = new PropertyBooking();
        booking.setPropertyId(bookingDTO.getPropertyId());
        booking.setUserId(bookingDTO.getUserId());
        booking.setStartDate(bookingDTO.getStartDate());
        booking.setEndDate(bookingDTO.getEndDate());
        booking.setTotalPrice(bookingDTO.getTotalPrice());
        booking.setBookingTime(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    @Override
    public boolean isPropertyAvailable(Long propertyId, LocalDate startDate, LocalDate endDate) {
        // If a booking exists in the date range, the property is NOT available.
        return !bookingRepository.existsBookingForDateRange(propertyId, startDate, endDate);
    }
}
