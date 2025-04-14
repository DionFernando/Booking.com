package com.booking.backend.repo;

import com.booking.backend.entity.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties, Long> {
}
