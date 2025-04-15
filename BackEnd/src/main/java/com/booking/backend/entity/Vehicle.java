package com.booking.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "vehicles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String type;

    private String brand;

    private Integer seats;

    private String color;

    @Lob
    private String description;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String image;

    private Double priceFor3Days;

    private String ownerEmail;
}
