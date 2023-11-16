
package com.lic.adjustment.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "policy_adjustment")
public class PolicyAdjustment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adjustment_date")
    private LocalDate adjustmentDate;

    // Add other fields and getters/setters as needed

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAdjustmentDate() {
        return adjustmentDate;
    }

    public void setAdjustmentDate(LocalDate adjustmentDate) {
        this.adjustmentDate = adjustmentDate;
    }
}
