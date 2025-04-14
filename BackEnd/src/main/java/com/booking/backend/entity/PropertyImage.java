/*
package com.booking.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "property_images")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyImage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Lob
    @Column(columnDefinition = "LONGBLOB") // For MySQL, use BYTEA for PostgreSQL
    private byte[] imageData;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private PropertySetup propertySetup;
}
*/
