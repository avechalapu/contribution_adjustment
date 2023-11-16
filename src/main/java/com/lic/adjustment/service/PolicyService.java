package com.lic.adjustment.service;

import com.lic.adjustment.model.Policy;
import com.lic.adjustment.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

    @Autowired
    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public Policy getPolicyById(long id) {
        return policyRepository.findById(id);
    }

    public List<Policy> getPoliciesByFrequency(String frequency) {
        return policyRepository.findByFrequency(frequency);
    }

    public List<Policy> getPoliciesByDeposit(String deposit) {
        return policyRepository.findByDeposit(deposit);
    }

    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public void deletePolicyById(long id) {
        policyRepository.deleteById(id);
    }

    // Additional methods based on your requirements

    public List<Policy> getPoliciesByUser(String user) {
        return policyRepository.findByUser(user);
    }

    public List<Policy> getPoliciesByStatus(String status) {
        return policyRepository.findByStatus(status);
    }

    public List<Policy> getPoliciesByAdjustmentType(String adjustmentType) {
        return policyRepository.findByAdjustmentType(adjustmentType);
    }

    public List<Policy> getPoliciesByApprovalStatus(String approvalStatus) {
        return policyRepository.findByApprovalStatus(approvalStatus);
    }
}

Note: This is a basic implementation of the Spring Boot Service class for the given repository. You can add more methods or modify the existing ones based on your specific requirements.