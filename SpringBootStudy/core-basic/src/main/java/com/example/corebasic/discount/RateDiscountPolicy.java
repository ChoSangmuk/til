package com.example.corebasic.discount;

import com.example.corebasic.member.Grade;
import com.example.corebasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountRate = 10;

    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? (price * discountRate) / 100 : 0;
    }
}