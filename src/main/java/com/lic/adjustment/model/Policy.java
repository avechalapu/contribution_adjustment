
package com.lic.adjustment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Policy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Add your fields/attributes here
    
    // Add your getters and setters here
    
    // Add any additional methods or annotations here
    
}
