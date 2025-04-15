package com.booking.backend.repo;

import com.booking.backend.entity.PropertyBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyBookingRepository extends JpaRepository<PropertyBooking, Long> {

    @Query("SELECT CASE WHEN COUNT(pb) > 0 THEN true ELSE false END " +
            "FROM PropertyBooking pb " +
            "WHERE pb.propertyId = :propertyId " +
            "AND pb.startDate <= :endDate " +
            "AND pb.endDate >= :startDate")
    boolean existsBookingForDateRange(@Param("propertyId") Long propertyId,
                                      @Param("startDate") java.time.LocalDate startDate,
                                      @Param("endDate") java.time.LocalDate endDate);
}
