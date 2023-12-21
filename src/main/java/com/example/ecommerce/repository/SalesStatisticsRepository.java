package com.example.ecommerce.repository;

import com.example.ecommerce.model.SalesStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesStatisticsRepository extends JpaRepository<SalesStatistics, Long> {
    List<SalesStatistics> findTopNProducts(int topN);
}