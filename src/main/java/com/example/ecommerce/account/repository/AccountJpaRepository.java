package com.example.ecommerce.account.repository;

import com.example.ecommerce.account.repository.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {
    List<AccountEntity> findByMemberId(Long memberId);
}