package com.example.corebasic.order;

import com.example.corebasic.discount.DiscountPolicy;
import com.example.corebasic.discount.RateDiscountPolicy;
import com.example.corebasic.member.Member;
import com.example.corebasic.member.MemberRepository;
import com.example.corebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    // 초기 설계에서는 MemberRepository, DiscountPolicy 인터페이스의 구현체인 MemoryMemberRepository, FixDiscountPolicy 를 직접 생성하여 사용
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // 새로운 할인 정책(RateDiscountPolicy)을 적용하기 위해 DiscountPolicy 의 구현체를 변경
    // 클라이언트의 소스도 변경이 발생해야함 -> OCP 원칙 위반
    // 인터페이스 뿐만 아니라 구현체까지 의존함 -> DIP 원칙 위반
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // DIP 원칙을 지키기 위해 구현체의 생성 부분을 삭제하면 DIP 원칙 준수할 수 있음
    // private final DiscountPolicy discountPolicy;

    // 그러나 구현체 없이 인터페이스만으로 로직을 실행하면 NullPointerException 이 발생
    // 외부에서 클라이언트(OrderServiceImpl)에 필요한 의존성(DiscountPolicy) 구현 객체를 대신 생성하고 주입하면 문제를 해결할 수 있음

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}