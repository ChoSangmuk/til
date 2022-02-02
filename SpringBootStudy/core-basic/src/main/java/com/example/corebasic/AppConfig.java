package com.example.corebasic;

import com.example.corebasic.discount.FixDiscountPolicy;
import com.example.corebasic.member.MemberService;
import com.example.corebasic.member.MemberServiceImpl;
import com.example.corebasic.member.MemoryMemberRepository;
import com.example.corebasic.order.OrderService;
import com.example.corebasic.order.OrderServiceImpl;

public class AppConfig {
    // MemberServiceImpl 생성 시, MemoryMemberRepository 를 생성하여 주입
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    // OrderServiceImpl 생성 시, MemoryMemberRepository, FixDiscountPolicy 를 생성하여 주입
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}