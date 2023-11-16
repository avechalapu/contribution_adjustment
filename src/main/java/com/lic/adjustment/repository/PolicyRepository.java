
package com.lic.adjustment.repository;

import com.lic.adjustment.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    // Method to fetch all policies from the database
    List<Policy> findAll();

    // Method to fetch a policy by its ID
    Policy findById(long id);

    // Method to fetch policies based on their frequency
    @Query("SELECT p FROM Policy p WHERE p.frequency = ?1")
    List<Policy> findByFrequency(String frequency);

    // Method to fetch policies with a specific deposit
    @Query("SELECT p FROM Policy p WHERE p.deposit = ?1")
    List<Policy> findByDeposit(String deposit);

    // Method to save a policy adjustment
    Policy save(Policy policy);

    // Method to delete a policy by its ID
    void deleteById(long id);

    // Additional methods based on your requirements

    // Method to fetch policies for a specific user
    List<Policy> findByUser(String user);

    // Method to fetch policies with a specific status
    List<Policy> findByStatus(String status);

    // Method to fetch policies with a specific adjustment type
    List<Policy> findByAdjustmentType(String adjustmentType);

    // Method to fetch policies with a specific approval status
    List<Policy> findByApprovalStatus(String approvalStatus);

}
