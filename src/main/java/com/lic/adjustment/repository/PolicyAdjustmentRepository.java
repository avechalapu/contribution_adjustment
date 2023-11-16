
package com.lic.adjustment.repository;

import com.lic.adjustment.model.PolicyAdjustment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PolicyAdjustmentRepository extends JpaRepository<PolicyAdjustment, Long> {

    // Custom query to get policy adjustments by date
    @Query("SELECT pa FROM PolicyAdjustment pa WHERE pa.adjustmentDate = ?1")
    List<PolicyAdjustment> findByAdjustmentDate(LocalDate adjustmentDate);

    // Custom query to get policy adjustments before a certain date
    @Query("SELECT pa FROM PolicyAdjustment pa WHERE pa.adjustmentDate < ?1")
    List<PolicyAdjustment> findBeforeAdjustmentDate(LocalDate adjustmentDate);

    // Custom query to get policy adjustments after a certain date
    @Query("SELECT pa FROM PolicyAdjustment pa WHERE pa.adjustmentDate > ?1")
    List<PolicyAdjustment> findAfterAdjustmentDate(LocalDate adjustmentDate);
}
