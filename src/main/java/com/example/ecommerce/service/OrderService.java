package com.example.ecommerce.service;

import com.example.ecommerce.model.Balance;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.SalesStatistics;
import com.example.ecommerce.repository.BalanceRepository;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.SalesStatisticsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.locks.Lock;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BalanceRepository balanceRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesStatisticsRepository salesStatisticsRepository;

    @Transactional
    public void placeOrder(Long userId, Long productId, int quantity) {
        // 주문 정보 확인 및 결제
        double productPrice = getProductPrice(productId);
        double totalPrice = productPrice * quantity;

        double userBalance = getUserBalance(userId);

        if (userBalance >= totalPrice) {
            // 상품 재고 확인 및 차감
            if (isProductInStock(productId, quantity)) {
                // 주문 생성 및 저장
                Order order = new Order();
                order.setUserId(userId);
                order.setProductId(productId);
                order.setQuantity(quantity);
                order.setTotalPrice(totalPrice);

                orderRepository.save(order);

                // 사용자 잔고 차감
                deductUserBalance(userId, totalPrice);

                // 상품 재고 차감
                deductProductStock(productId, quantity);

                // 판매 통계 업데이트
                updateSalesStatistics(productId, quantity);
            }
        }
    }

    private double getProductPrice(Long productId) {
        // 상품 가격 조회 로직
        // ...

        return 0.0;
    }

    private double getUserBalance(Long userId) {
        Optional<Balance> optionalBalance = balanceRepository.findById(userId);
        return (double) optionalBalance.map(Balance::getAmount).orElse(0.0);
    }

    private boolean isProductInStock(Long productId, int quantity) {
        // 상품 재고 확인 로직
        // ...

        return true;
    }

    private void deductUserBalance(Long userId, double amount) {
        Optional<Balance> optionalBalance = balanceRepository.findById(userId);
        if (optionalBalance.isPresent()) {
            Balance balance = optionalBalance.get();
            double newAmount = balance.getAmount() - amount; // 두 값의 타입을 맞춤
            balance.setAmount(newAmount);
            balanceRepository.save(balance);
        }
    }


    private void deductProductStock(Long productId, int quantity) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            int remainingStock = product.getQuantity() - quantity;
            product.setQuantity(Math.max(remainingStock, 0));
            productRepository.save(product);
        }
    }

    private void updateSalesStatistics(Long productId, int quantity) {
        // 판매 통계 업데이트 로직
        // ...

        SalesStatistics salesStatistics = new SalesStatistics();
        salesStatistics.setProductId(productId);
        salesStatistics.setQuantitySold(quantity);

        salesStatisticsRepository.save(salesStatistics);
    }

    public void placeOrder(Order order) {
    }
}