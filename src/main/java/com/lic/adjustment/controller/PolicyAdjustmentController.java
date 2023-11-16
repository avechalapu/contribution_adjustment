package com.lic.adjustment.controller;

import com.lic.adjustment.model.PolicyAdjustment;
import com.lic.adjustment.service.PolicyAdjustmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/policy-adjustments")
public class PolicyAdjustmentController {

    private final PolicyAdjustmentService policyAdjustmentService;

    @Autowired
    public PolicyAdjustmentController(PolicyAdjustmentService policyAdjustmentService) {
        this.policyAdjustmentService = policyAdjustmentService;
    }

    @GetMapping("/by-date")
    public ResponseEntity<List<PolicyAdjustment>> getPolicyAdjustmentsByDate(@RequestParam("adjustmentDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate adjustmentDate) {
        List<PolicyAdjustment> policyAdjustments = policyAdjustmentService.getPolicyAdjustmentsByDate(adjustmentDate);
        return new ResponseEntity<>(policyAdjustments, HttpStatus.OK);
    }

    @GetMapping("/before-date")
    public ResponseEntity<List<PolicyAdjustment>> getPolicyAdjustmentsBeforeDate(@RequestParam("adjustmentDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate adjustmentDate) {
        List<PolicyAdjustment> policyAdjustments = policyAdjustmentService.getPolicyAdjustmentsBeforeDate(adjustmentDate);
        return new ResponseEntity<>(policyAdjustments, HttpStatus.OK);
    }

    @GetMapping("/after-date")
    public ResponseEntity<List<PolicyAdjustment>> getPolicyAdjustmentsAfterDate(@RequestParam("adjustmentDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate adjustmentDate) {
        List<PolicyAdjustment> policyAdjustments = policyAdjustmentService.getPolicyAdjustmentsAfterDate(adjustmentDate);
        return new ResponseEntity<>(policyAdjustments, HttpStatus.OK);
    }

    // Add other business methods as needed

}
