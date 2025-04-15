package com.booking.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "saved_vehicles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userId", "vehicle_id"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavedVehicle {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private String userId; // ID of the user who saved the vehicle

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
}
