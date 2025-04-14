package com.booking.backend.repo;

import com.booking.backend.entity.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties, Long> {
    List<Properties> findByUserEmail(String userEmail);
}
