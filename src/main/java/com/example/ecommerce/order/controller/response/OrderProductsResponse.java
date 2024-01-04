package com.example.ecommerce.order.controller.response;

import lombok.Builder;

public record OrderProductsResponse(
        Long orderId
) {
    @Builder
    public OrderProductsResponse {}
}
