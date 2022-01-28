package com.example.corebasic.discount;

import com.example.corebasic.member.Grade;
import com.example.corebasic.member.Member;

// 할인 정책 - 정액 할인
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1_000; // 1,000원 할인

    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? discountFixAmount : 0;
    }
}