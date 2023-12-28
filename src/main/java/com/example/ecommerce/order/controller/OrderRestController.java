package com.example.ecommerce.order.controller;

import  com.example.ecommerce.CommonResponse;
import  com.example.ecommerce.order.controller.request.OrderProductsRequest;
import  com.example.ecommerce.order.controller.response.OrderProductsResponse;
import  com.example.ecommerce.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping("/request")
    public ResponseEntity<?> requestOrders(@Valid @RequestBody OrderProductsRequest request) {
        Long orderId = orderService.requestOrder(request.toOrder());
        return ResponseEntity.ok(CommonResponse.ok(OrderProductsResponse.builder().orderId(orderId).build()));
    }
}