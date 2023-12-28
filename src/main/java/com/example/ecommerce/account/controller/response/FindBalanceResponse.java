package com.example.ecommerce.account.controller.response;

import  com.example.ecommerce.account.service.domain.Account;

import java.util.List;

// 주어진 Account 리스트에서 잔액의 총 합계를 계산하여 FindBalanceResponse 객체 생성

// record는 한번 생성 된 후 수정X
public record FindBalanceResponse(
        Long totalBalance,
        List<Account> accounts
) {

    // from 메서드 :FindBalanceResponse 객체 생성 역할, List<Account> 를 받아서 총 잔액 계산후
    // 계산된 잔액과 원래의 List<Account>를 이용해 FindBalanceResponse 리턴
    public static FindBalanceResponse from(List<Account> accounts) {
        long total = 0;
        for (Account account : accounts) {
            total += account.getBalance();
        }

        return new FindBalanceResponse(total, accounts);
    }

}