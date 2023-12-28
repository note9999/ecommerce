package com.example.ecommerce.order.controller.request;

import com.example.ecommerce.order.status.OrderStatus;
import com.example.ecommerce.order.service.domain.Order;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderProductsRequest(
        @NotNull
        Long memberId,
        List<@Valid OrderProductRequest> products
) {
    public Order toOrder() {
        return Order.builder()
                .memberId(memberId)
                .status(OrderStatus.REQUEST)
                .products(products.stream().map(OrderProductRequest::toOrderProduct).toList())
                .build();
    }
}