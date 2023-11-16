
package com.lic.adjustment.service;

import com.lic.adjustment.model.PolicyAdjustment;
import com.lic.adjustment.repository.PolicyAdjustmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PolicyAdjustmentService {

    private final PolicyAdjustmentRepository policyAdjustmentRepository;

    @Autowired
    public PolicyAdjustmentService(PolicyAdjustmentRepository policyAdjustmentRepository) {
        this.policyAdjustmentRepository = policyAdjustmentRepository;
    }

    public List<PolicyAdjustment> getPolicyAdjustmentsByDate(LocalDate adjustmentDate) {
        return policyAdjustmentRepository.findByAdjustmentDate(adjustmentDate);
    }

    public List<PolicyAdjustment> getPolicyAdjustmentsBeforeDate(LocalDate adjustmentDate) {
        return policyAdjustmentRepository.findBeforeAdjustmentDate(adjustmentDate);
    }

    public List<PolicyAdjustment> getPolicyAdjustmentsAfterDate(LocalDate adjustmentDate) {
        return policyAdjustmentRepository.findAfterAdjustmentDate(adjustmentDate);
    }

    // Add other business methods as needed

}
