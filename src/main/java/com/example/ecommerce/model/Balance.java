
package com.example.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Balance {
    @Id
    private Long userId;
    private double amount;

    // Getter and Setter
}
