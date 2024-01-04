package com.example.ecommerce.account.repository.entity;

import  com.example.ecommerce.account.service.domain.Account;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파리미터 없는 기본생성자 자동으로 생성
@AllArgsConstructor(access = AccessLevel.PRIVATE) // 모든 필드를 매개변수로 받는 생성자 자동으로 생성, priviate으로 외부 생성자 호출 막음
@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long memberId;

    @Column
    private Long balance;

    @Column
    private Long creator;

    @Column
    private Long lastModifier;

    public static AccountEntity create(Account account) {
        return AccountEntity.builder()
                .memberId(account.getMemberId())
                .balance(account.getBalance())
                .creator(account.getMemberId())
                .build();
    }

    public void updateBalance(Long balance) {
        this.balance += balance;
    }

    public Account toAccount() {
        return Account.builder()
                .id(id)
                .memberId(memberId)
                .balance(balance)
                .createdAt(super.getCreatedAt())
                .build();
    }
}