package com.example.ecommerce.account.controller.response;

import lombok.Builder;

public record ChargeBalanceResponse(
        Long accountId
) {
    @Builder
    public ChargeBalanceResponse {}
}