package com.example.ecommerce.repository;

import com.example.ecommerce.model.SalesStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesStatisticsRepository extends JpaRepository<SalesStatistics, Long> {
}