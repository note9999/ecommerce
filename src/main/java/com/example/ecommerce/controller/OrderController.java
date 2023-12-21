package com.example.ecommerce.controller;

import com.example.ecommerce.exception.InsufficientBalanceException;
import com.example.ecommerce.exception.InsufficientStockException;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public void placeOrder(@RequestBody Order order) throws InsufficientStockException, InsufficientBalanceException {
        orderService.placeOrder(order);
    }
}

