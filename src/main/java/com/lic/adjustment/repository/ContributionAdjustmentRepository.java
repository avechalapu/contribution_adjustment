
package com.lic.adjustment.repository;

import com.lic.adjustment.model.ContributionAdjustment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContributionAdjustmentRepository extends JpaRepository<ContributionAdjustment, Long> {

    // Query to retrieve all contribution adjustments for a specific policy version
    @Query("SELECT ca FROM ContributionAdjustment ca WHERE ca.policyVersion = ?1")
    List<ContributionAdjustment> findByPolicyVersion(String policyVersion);

    // Query to retrieve all contribution adjustments submitted for approval
    @Query("SELECT ca FROM ContributionAdjustment ca WHERE ca.status = 'SUBMITTED'")
    List<ContributionAdjustment> findSubmittedAdjustments();

    // Query to retrieve all contribution adjustments that are approved or rejected
    @Query("SELECT ca FROM ContributionAdjustment ca WHERE ca.status IN ('APPROVED', 'REJECTED')")
    List<ContributionAdjustment> findApprovedOrRejectedAdjustments();

    // Query to retrieve the total contribution adjustments for a specific policy version
    @Query("SELECT SUM(ca.adjustmentAmount) FROM ContributionAdjustment ca WHERE ca.policyVersion = ?1")
    Double getTotalAdjustmentAmountByPolicyVersion(String policyVersion);
}
