package com.example.corebasic;

import com.example.corebasic.discount.DiscountPolicy;
import com.example.corebasic.discount.RateDiscountPolicy;
import com.example.corebasic.member.MemberRepository;
import com.example.corebasic.member.MemberService;
import com.example.corebasic.member.MemberServiceImpl;
import com.example.corebasic.member.MemoryMemberRepository;
import com.example.corebasic.order.OrderService;
import com.example.corebasic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        /*
         초기 설계에서는 MemberServiceImpl 생성 시, MemoryMemberRepository 를 직접 생성하여 주입
         return new MemberServiceImpl(new MemoryMemberRepository());

         리팩터링 후, memberRepository()를 호출한 결과를 주입
        */
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        /*
         초기 설계에서는 OrderServiceImpl 생성 시, MemoryMemberRepository, FixDiscountPolicy 를 직접 생성하여 주입
         return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

         리팩터링 후, memberRepository()와 discountPolicy()를 호출한 결과를 주입
        */
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        // MemberRepository 역할은 MemoryMemberRepository 구현체로 설정
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        /*
         DiscountPolicy 역할은 FixDiscountPolicy 구현체로 설정
         return new FixDiscountPolicy();

         새로운 할인 정책 적용
         DiscountPolicy 역할은 RateDiscountPolicy 구현체로 설정
        */
        return new RateDiscountPolicy();
    }
}