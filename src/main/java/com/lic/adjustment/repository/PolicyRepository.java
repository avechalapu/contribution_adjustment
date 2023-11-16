
package com.lic.adjustment.repository;

import com.lic.adjustment.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    // Method to fetch and display a list of policies from the database
    List<Policy> findAll();

    // Method to fetch a policy by ID
    Policy findById(long id);

    // Method to fetch policies based on specific conditions
    // Replace the placeholders with your actual conditions
    @Query("SELECT p FROM Policy p WHERE <conditions>")
    List<Policy> findByConditions();

    // Method to save a policy adjustment in draft status
    Policy save(Policy policy);

    // Method to fetch adjustments by status
    // Replace the placeholder with your actual status
    List<Policy> findByStatus(String status);

    // Other required methods can be added here
    
}
