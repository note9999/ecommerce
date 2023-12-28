package com.example.ecommerce.account.service;

import com.example.ecommerce.account.service.domain.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> findAccountsOf(Long memberId);
    Account findAccountOf(Long accountId);
    void save(Account account);
    void update(Account account);
}