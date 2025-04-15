package com.booking.backend.dto;

import java.time.LocalDate;

public class PropertyBookingDTO {

    private Long propertyId;
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalPrice;

    public PropertyBookingDTO() { }

    public PropertyBookingDTO(Long propertyId, Long userId, LocalDate startDate, LocalDate endDate, Double totalPrice) {
        this.propertyId = propertyId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
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
}
