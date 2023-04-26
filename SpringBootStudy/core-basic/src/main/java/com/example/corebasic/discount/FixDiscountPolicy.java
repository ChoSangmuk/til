package com.example.corebasic.discount;

import com.example.corebasic.member.Grade;
import com.example.corebasic.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// 할인 정책 - 정액 할인
@Component
// 조회 빈이 2개 이상인 경우 학습을 위해 추가
@Primary
// 의존관계 자동 주입 시, Qualifier 를 지정하지 않으면 FixDiscountPolicy 가 기본값으로 사용됨
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1_000; // 1,000원 할인

    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? discountFixAmount : 0;
    }
}