package com.lic.adjustment.service;

import com.lic.adjustment.model.Policy;
import com.lic.adjustment.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

    @Autowired
    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    // Search policies by policy number
    public List<Policy> searchPoliciesByPolicyNumber(String policyNumber) {
        return policyRepository.findByPolicyNumber(policyNumber);
    }

    // Search policies by policyholder name
    public List<Policy> searchPoliciesByPolicyholderName(String policyholderName) {
        return policyRepository.findByPolicyholderName(policyholderName);
    }

    // Search policies by date range
    public List<Policy> searchPoliciesByDateRange(Date startDate, Date endDate) {
        return policyRepository.findByStartDateBetween(startDate, endDate);
    }

    // Search policies by policy status
    public List<Policy> searchPoliciesByPolicyStatus(String policyStatus) {
        return policyRepository.findByPolicyStatus(policyStatus);
    }

    // Fetch comprehensive policy details by policy id
    public Policy fetchPolicyDetailsById(Long policyId) {
        return policyRepository.fetchPolicyDetailsById(policyId);
    }

    // Add additional business methods for policy adjustments here

}
