package com.example.ecommerce.order.service.domain;

import com.example.ecommerce.common.exception.CustomException;
import com.example.ecommerce.order.status.OrderStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static com.example.ecommerce.common.status.CustomExceptionStatus.ORDER_NOT_MATCH_OWNER;

@Getter
public class Order {
    private Long id;
    private OrderStatus status;
    private Long memberId;
    private List<OrderProduct> products;
    private LocalDateTime createdAt;

    @Builder
    public Order(Long id, OrderStatus status, Long memberId, List<OrderProduct> products, LocalDateTime createdAt) {
        this.id = id;
        this.status = status;
        this.memberId = memberId;
        this.products = products;
        this.createdAt = createdAt;
    }

    public void checkOwner(Long memberId) {
        if (!Objects.equals(memberId, this.memberId)) {
            throw new CustomException(ORDER_NOT_MATCH_OWNER);
        }
    }
}