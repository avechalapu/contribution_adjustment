package com.lic.adjustment.controller;

import com.lic.adjustment.model.Policy;
import com.lic.adjustment.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping("/")
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable long id) {
        return policyService.getPolicyById(id);
    }

    @GetMapping("/frequency/{frequency}")
    public List<Policy> getPoliciesByFrequency(@PathVariable String frequency) {
        return policyService.getPoliciesByFrequency(frequency);
    }

    @GetMapping("/deposit/{deposit}")
    public List<Policy> getPoliciesByDeposit(@PathVariable String deposit) {
        return policyService.getPoliciesByDeposit(deposit);
    }

    @PostMapping("/")
    public Policy savePolicy(@RequestBody Policy policy) {
        return policyService.savePolicy(policy);
    }

    @DeleteMapping("/{id}")
    public void deletePolicyById(@PathVariable long id) {
        policyService.deletePolicyById(id);
    }

    // Additional methods mapping

    @GetMapping("/user/{user}")
    public List<Policy> getPoliciesByUser(@PathVariable String user) {
        return policyService.getPoliciesByUser(user);
    }

    @GetMapping("/status/{status}")
    public List<Policy> getPoliciesByStatus(@PathVariable String status) {
        return policyService.getPoliciesByStatus(status);
    }

    @GetMapping("/adjustmentType/{adjustmentType}")
    public List<Policy> getPoliciesByAdjustmentType(@PathVariable String adjustmentType) {
        return policyService.getPoliciesByAdjustmentType(adjustmentType);
    }

    @GetMapping("/approvalStatus/{approvalStatus}")
    public List<Policy> getPoliciesByApprovalStatus(@PathVariable String approvalStatus) {
        return policyService.getPoliciesByApprovalStatus(approvalStatus);
    }
}

Note: This is a basic implementation of the Spring Boot Controller class for the given Service class. You can add more methods or modify the existing ones based on your specific requirements. Make sure to update the package name accordingly in your project.