package com.booking.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "property_bookings")
public class PropertyBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ID of the booked property.
    @Column(name = "property_id", nullable = false)
    private Long propertyId;

    // ID of the user who made the booking.
    @Column(name = "user_id", nullable = false)
    private Long userId;

    // Booking start date.
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    // Booking end date.
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    // Total price for the booking.
    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    // Timestamp when the booking was created.
    @Column(name = "booking_time", nullable = false)
    private LocalDateTime bookingTime;

    // Constructors
    public PropertyBooking() { }

    public PropertyBooking(Long propertyId, Long userId, LocalDate startDate, LocalDate endDate, Double totalPrice, LocalDateTime bookingTime) {
        this.propertyId = propertyId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.bookingTime = bookingTime;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public Long getPropertyId() { return propertyId; }
    public void setPropertyId(Long propertyId) { this.propertyId = propertyId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
    public LocalDateTime getBookingTime() { return bookingTime; }
    public void setBookingTime(LocalDateTime bookingTime) { this.bookingTime = bookingTime; }
}
