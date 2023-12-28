package com.example.ecommerce.product.service.component;


import com.example.ecommerce.order.service.OrderRepository;
import com.example.ecommerce.order.service.domain.SoldProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderManager {
    private final OrderRepository orderRepository;

    public List<SoldProduct> getOrderProductsIn(LocalDate searchDate, int duration, int count) {
        return orderRepository.findOrderProductsIn(searchDate, duration, count);
    }
}