package com.example.ecommerce.account.controller;

import com.example.ecommerce.account.controller.request.BalanceChargeRequest;
import com.example.ecommerce.account.controller.response.ChargeBalanceResponse;
import com.example.ecommerce.account.controller.response.FindBalanceResponse;
import com.example.ecommerce.account.service.AccountService;
import com.example.ecommerce.account.service.domain.Account;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Slf4j
    @RestController
    @RequiredArgsConstructor
    public class AccountRestController {
        private final AccountService accountService;

        @GetMapping("/balance")
        public ResponseEntity<?> findBalancesOf(@RequestHeader(name = "Authorization") Long memberId) {
        List<Account> accounts = accountService.findBalanceOf(memberId);
        return ResponseEntity.ok(CommonResponse.ok(FindBalanceResponse.from(accounts)));
    }

    @PutMapping("/balance/charge")
    public ResponseEntity<?> chargeBalanceOf(@RequestBody @Valid BalanceChargeRequest request) {
        Long chargedAccountId = accountService.chargeBalance(request.memberId(), request.accountId(), request.amount());
        return ResponseEntity.ok(CommonResponse.ok(ChargeBalanceResponse.builder().accountId(chargedAccountId).build()));
    }
}