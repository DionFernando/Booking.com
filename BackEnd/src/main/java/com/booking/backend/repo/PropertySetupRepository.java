package com.booking.backend.repo;

import com.booking.backend.entity.PropertySetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PropertySetupRepository extends JpaRepository<PropertySetup, UUID> {
}

