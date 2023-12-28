package com.example.ecommerce.account.repository;

import com.example.ecommerce.account.repository.entity.AccountEntity;
import com.example.ecommerce.account.service.AccountRepository;
import com.example.ecommerce.account.service.domain.Account;
import com.example.ecommerce.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.ecommerce.status.CustomExceptionStatus.ACCOUNT_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {
    private final AccountJpaRepository repository;

    @Override
    public List<Account> findAccountsOf(Long memberId) {
        return repository.findByMemberId(memberId).stream()
                .map(AccountEntity::toAccount)
                .toList();
    }

    @Override
    public Account findAccountOf(Long accountId) {
        return repository.findById(accountId)
                .orElseThrow(() -> new CustomException(ACCOUNT_NOT_FOUND))
                .toAccount();
    }

    @Override
    public void save(Account account) {
        repository.save(AccountEntity.create(account));
    }

    @Override
    public void update(Account account) {
        repository.findById(account.getId())
                .ifPresent(accountEntity -> accountEntity.updateBalance(account.getBalance()));
    }
}