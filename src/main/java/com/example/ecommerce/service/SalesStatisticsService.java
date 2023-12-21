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
        // 판매 통계를 기반으로 상위 N개 제품을 검색하는 논리 구현
        //

        return salesStatisticsRepository.findTopNProducts(topN);
    }

    // 추가 메서드 생성
}