package com.example.ecommerce.service;

import com.example.ecommerce.model.Balance;
import com.example.ecommerce.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BalanceService {
    @Autowired
    private BalanceRepository balanceRepository;

    public double getBalance(Long userId) {
        Optional<Balance> optionalBalance = balanceRepository.findById(userId);
        return (double) optionalBalance.map(Balance::getAmount).orElse(0.0);
    }

    public void chargeBalance(Long userId, double amount) {
        Optional<Balance> optionalBalance = balanceRepository.findById(userId);
        Balance balance = optionalBalance.orElse(new Balance());
        balance.setUserId(userId);
        balance.setAmount(balance.getAmount() + amount);
        balanceRepository.save(balance);
    }
}