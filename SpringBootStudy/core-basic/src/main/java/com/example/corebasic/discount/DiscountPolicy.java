package com.example.corebasic.discount;

import com.example.corebasic.member.Member;

// 할인 정책
public interface DiscountPolicy {
    /**
     * 할인 금액 계산
     *
     * @param member 사용자 정보
     * @param price  주문 가격
     * @return 할인 금액
     */
    int discount(Member member, int price);
}