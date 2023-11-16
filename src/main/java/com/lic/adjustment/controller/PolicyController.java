
package com.lic.adjustment.controller;

import com.lic.adjustment.model.Policy;
import com.lic.adjustment.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PolicyController {

    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping("/policies/search")
    public List<Policy> searchPolicies(@RequestParam(required = false) String policyNumber,
                                       @RequestParam(required = false) String policyholderName,
                                       @RequestParam(required = false) Date startDate,
                                       @RequestParam(required = false) Date endDate,
                                       @RequestParam(required = false) String policyStatus) {

        if (policyNumber != null) {
            return policyService.searchPoliciesByPolicyNumber(policyNumber);
        } else if (policyholderName != null) {
            return policyService.searchPoliciesByPolicyholderName(policyholderName);
        } else if (startDate != null && endDate != null) {
            return policyService.searchPoliciesByDateRange(startDate, endDate);
        } else if (policyStatus != null) {
            return policyService.searchPoliciesByPolicyStatus(policyStatus);
        } else {
            // No search parameters provided, return all policies
            return policyService.getAllPolicies();
        }
    }

    @GetMapping("/policies/{policyId}")
    public Policy fetchPolicyDetailsById(@PathVariable Long policyId) {
        return policyService.fetchPolicyDetailsById(policyId);
    }

    // Add additional methods for policy adjustments here

}
