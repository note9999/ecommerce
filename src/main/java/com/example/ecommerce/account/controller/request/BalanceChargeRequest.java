package com.example.ecommerce.account.controller.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive; // Jakarta Validation API의 일부, 변수나 매개변수가 양수여야함

public record BalanceChargeRequest(
        @NotNull
        Long memberId,
        @NotNull
        Long accountId,
        @Positive
        Long amount
) {
}