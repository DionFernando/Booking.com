package com.booking.backend.dto;

public class PropertiesDTO {
    private String type;
    private String name;
    private String country;
    private String city;
    private String address;
    private String description;
    private int bedCount;
    private double price;  // per day

    // Getters and Setters

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getBedCount() {
        return bedCount;
    }
    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
