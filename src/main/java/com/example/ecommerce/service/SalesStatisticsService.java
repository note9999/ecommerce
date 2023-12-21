// com.example.ecommerce.service.SalesStatisticsService.java
package com.example.ecommerce.service;

import com.example.ecommerce.model.SalesStatistics;
import com.example.ecommerce.repository.SalesStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesStatisticsService {

    @Autowired
    private SalesStatisticsRepository salesStatisticsRepository;

    public List<SalesStatistics> getAllSalesStatistics() {
        return salesStatisticsRepository.findAll();
    }

    public List<SalesStatistics> getTopProducts(int topN) {
        // Implement logic to retrieve the top N products based on sales statistics
        // ...

        return salesStatisticsRepository.findTopNProducts(topN);
    }

    // You can add more methods based on your specific requirements
}