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

    public List<Policy> getPoliciesByConditions() {
        return policyRepository.findByConditions();
    }

    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public List<Policy> getPoliciesByStatus(String status) {
        return policyRepository.findByStatus(status);
    }

    // Other required methods can be added here
    
}
