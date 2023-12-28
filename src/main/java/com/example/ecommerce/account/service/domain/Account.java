package com.example.ecommerce.account.service.domain;

import com.example.ecommerce.exception.CustomException;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.example.ecommerce.status.CustomExceptionStatus.ACCOUNT_NOT_CHARGE_MINUS;
import static com.example.ecommerce.status.CustomExceptionStatus.ACCOUNT_NOT_MATCH_OWNER;

@Getter
public class Account {
    private Long id;
    private Long memberId;  // 회원 id
    private Long balance;   // 계좌 잔액
    private LocalDateTime createdAt; // 계좌가 생성된 일시


    //많은 매개변수를 갖는 생성자를 대체
    @Builder
    public Account(Long id, Long memberId, Long balance, LocalDateTime createdAt) {
        this.id = id;
        this.memberId = memberId;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    // 계좌의 소유주가 맞는 지 확인하는 매서드
    // 인자로 전달된 memberId와 해당 계좌의 memberID를 비교해 일치하지 않을 경우 CustomException 발생
    public void checkOwner(Long memberId) {
        if (!Objects.equals(memberId, this.memberId)) {
            throw new CustomException(ACCOUNT_NOT_MATCH_OWNER);
        }
    }

    //계좌에 입금하는 메서드. 인자로 전달된 amount를 잔액에 더함

    public void charge(long amount) {
        isPositive(amount);
        balance += amount;
    }
    // isPositive 메서드를 호출하여 입금 금액이 음수인지 확인하고, 음수일 경우 CustomException을 발생
    private void isPositive(long amount) {
        if (amount < 0) {
            throw new CustomException(ACCOUNT_NOT_CHARGE_MINUS);
        }
    }
}