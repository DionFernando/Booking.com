package com.booking.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "property_setup")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertySetup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String name;

    private String guestCount;
    private String bedCount;
    private String description;
    private String price;

    @OneToMany(mappedBy = "propertySetup", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PropertyImage> images;
}
