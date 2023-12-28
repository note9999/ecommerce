package com.example.ecommerce.member.service;

import  com.example.ecommerce.member.service.domain.Member;

public interface MemberRepository {
    Member findById(Long id);
}