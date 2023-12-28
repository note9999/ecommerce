package com.example.ecommerce.account.service;

import com.example.ecommerce.account.service.component.MemberReader;
import com.example.ecommerce.account.service.domain.Account;
import com.example.ecommerce.member.service.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class AccountService {
    private final AccountRepository accountRepository;

    private final MemberReader memberReader;

    @Transactional(readOnly = true)
    public Account findAccount(Long accountId) {
        return accountRepository.findAccountOf(accountId);
    }

    @Transactional(readOnly = true)
    public List<Account> findBalanceOf(Long memberId) {
        Member member = memberReader.getMember(memberId);  // 해당회원이 실제 존재하는 지 확인
        return accountRepository.findAccountsOf(member.getId());
    }

    public Long chargeBalance(Long memberId, Long accountId, Long amount) {
        Account account = findAccount(accountId);
        account.checkOwner(memberId);
        account.charge(amount);

        accountRepository.update(account);

        return account.getId();
    }
}