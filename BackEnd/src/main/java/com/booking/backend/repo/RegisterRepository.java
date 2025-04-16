package com.booking.backend.repo;

import com.booking.backend.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegisterRepository extends JpaRepository<Register, UUID> {

    Register findByEmail(String userName);

    boolean existsByEmail(String userName);

    int deleteByEmail(String userName);

}