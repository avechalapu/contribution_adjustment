
package com.lic.adjustment.controller;

import com.lic.adjustment.model.ContributionAdjustment;
import com.lic.adjustment.service.ContributionAdjustmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adjustments")
public class ContributionAdjustmentController {

    private final ContributionAdjustmentService contributionAdjustmentService;

    @Autowired
    public ContributionAdjustmentController(ContributionAdjustmentService contributionAdjustmentService) {
        this.contributionAdjustmentService = contributionAdjustmentService;
    }

    @GetMapping("/policy-version/{policyVersion}")
    public List<ContributionAdjustment> findByPolicyVersion(@PathVariable String policyVersion) {
        return contributionAdjustmentService.findByPolicyVersion(policyVersion);
    }

    @GetMapping("/submitted")
    public List<ContributionAdjustment> findSubmittedAdjustments() {
        return contributionAdjustmentService.findSubmittedAdjustments();
    }

    @GetMapping("/approved-or-rejected")
    public List<ContributionAdjustment> findApprovedOrRejectedAdjustments() {
        return contributionAdjustmentService.findApprovedOrRejectedAdjustments();
    }

    @GetMapping("/total-amount/{policyVersion}")
    public Double getTotalAdjustmentAmountByPolicyVersion(@PathVariable String policyVersion) {
        return contributionAdjustmentService.getTotalAdjustmentAmountByPolicyVersion(policyVersion);
    }
}
