package com.example.ecommerce.controller;

import com.example.ecommerce.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/balance")
public class BalanceController {
    @Autowired
    private BalanceService balanceService;

    @GetMapping
    public double getBalance(@RequestParam Long userId) {
        return balanceService.getBalance(userId);
    }

    @PostMapping("/charge")
    public void chargeBalance(@RequestParam Long userId, @RequestParam double amount) {
        balanceService.chargeBalance(userId, amount);
    }
}