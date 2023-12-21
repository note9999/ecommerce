
package com.example.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Balance {
    @Id
    private Long userId;
    @Getter
    // amount는 사용자 계좌 잔액
    private double amount;

    public void setAmount() {
        setAmount(0.0);
    }

    public void setAmount(double v) {
    }

    public void setUserId(Long userId) {

    }

    // Getter and Setter
}
