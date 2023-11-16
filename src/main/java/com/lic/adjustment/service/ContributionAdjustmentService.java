
package com.lic.adjustment.service;

import com.lic.adjustment.model.ContributionAdjustment;
import com.lic.adjustment.repository.ContributionAdjustmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContributionAdjustmentService {

    private final ContributionAdjustmentRepository contributionAdjustmentRepository;

    @Autowired
    public ContributionAdjustmentService(ContributionAdjustmentRepository contributionAdjustmentRepository) {
        this.contributionAdjustmentRepository = contributionAdjustmentRepository;
    }

    public List<ContributionAdjustment> findByPolicyVersion(String policyVersion) {
        return contributionAdjustmentRepository.findByPolicyVersion(policyVersion);
    }

    public List<ContributionAdjustment> findSubmittedAdjustments() {
        return contributionAdjustmentRepository.findSubmittedAdjustments();
    }

    public List<ContributionAdjustment> findApprovedOrRejectedAdjustments() {
        return contributionAdjustmentRepository.findApprovedOrRejectedAdjustments();
    }

    public Double getTotalAdjustmentAmountByPolicyVersion(String policyVersion) {
        return contributionAdjustmentRepository.getTotalAdjustmentAmountByPolicyVersion(policyVersion);
    }
}
