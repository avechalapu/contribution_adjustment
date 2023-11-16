
package com.lic.adjustment.repository;

import com.lic.adjustment.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    // Search policies by policy number
    List<Policy> findByPolicyNumber(String policyNumber);

    // Search policies by policyholder name
    List<Policy> findByPolicyholderName(String policyholderName);

    // Search policies by date range
    List<Policy> findByStartDateBetween(Date startDate, Date endDate);

    // Search policies by policy status
    List<Policy> findByPolicyStatus(String policyStatus);

    // Fetch comprehensive policy details by policy id
    @Query("SELECT p FROM Policy p JOIN FETCH p.premiums pr JOIN FETCH p.beneficiaries b WHERE p.id = :policyId")
    Policy fetchPolicyDetailsById(Long policyId);

}
