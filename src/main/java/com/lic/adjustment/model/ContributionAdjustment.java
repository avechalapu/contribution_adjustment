
package com.lic.adjustment.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "contribution_adjustment")
public class ContributionAdjustment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "policy_version")
    private String policyVersion;

    @Column(name = "status")
    private String status;

    @Column(name = "adjustment_amount")
    private Double adjustmentAmount;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyVersion() {
        return policyVersion;
    }

    public void setPolicyVersion(String policyVersion) {
        this.policyVersion = policyVersion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAdjustmentAmount() {
        return adjustmentAmount;
    }

    public void setAdjustmentAmount(Double adjustmentAmount) {
        this.adjustmentAmount = adjustmentAmount;
    }

    // Equals and HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContributionAdjustment that = (ContributionAdjustment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(policyVersion, that.policyVersion) &&
                Objects.equals(status, that.status) &&
                Objects.equals(adjustmentAmount, that.adjustmentAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, policyVersion, status, adjustmentAmount);
    }
}
