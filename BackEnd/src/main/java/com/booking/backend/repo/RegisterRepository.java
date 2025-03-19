package com.booking.backend.repo;

import com.booking.backend.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register,String> {

    Register findByEmail(String userName);

    boolean existsByEmail(String userName);

    int deleteByEmail(String userName);

}