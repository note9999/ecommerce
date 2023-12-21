package com.example.ecommerce.model;

import jakarta.persistence.*;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Version;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long productId;
    private int quantity;
    private double totalPrice;

    @Version
    private Long version;

    // Getter and Setter

    // 추가: 주문에 대한 잠금을 위한 ReentrantLock
    private transient Lock orderLock = new ReentrantLock();

    public void setUserId(Long userId) {

    }

    public void setProductId(Long productId) {

    }

    public void setQuantity(int quantity) {

    }

    public void setTotalPrice(double totalPrice) {

    }
}
