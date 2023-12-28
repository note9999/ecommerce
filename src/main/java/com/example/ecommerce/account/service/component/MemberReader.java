package com.example.ecommerce.account.service.component;

import com.example.ecommerce.member.service.MemberRepository;
import com.example.ecommerce.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberReader {
    private final MemberRepository memberRepository;

    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}