package com.example.corebasic.order;

import com.example.corebasic.discount.DiscountPolicy;
import com.example.corebasic.discount.FixDiscountPolicy;
import com.example.corebasic.member.Member;
import com.example.corebasic.member.MemberRepository;
import com.example.corebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    // 초기 설계에서는 MemberRepository, DiscountPolicy 인터페이스의 구현체인 MemoryMemberRepository, FixDiscountPolicy 를 직접 생성하여 사용
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}