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

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable long id) {
        return policyService.getPolicyById(id);
    }

    @GetMapping("/conditions")
    public List<Policy> getPoliciesByConditions() {
        return policyService.getPoliciesByConditions();
    }

    @PostMapping
    public Policy savePolicy(@RequestBody Policy policy) {
        return policyService.savePolicy(policy);
    }

    @GetMapping("/status/{status}")
    public List<Policy> getPoliciesByStatus(@PathVariable String status) {
        return policyService.getPoliciesByStatus(status);
    }

    // Other required methods can be added here

}
