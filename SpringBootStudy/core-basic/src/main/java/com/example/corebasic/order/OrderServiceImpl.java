package com.example.corebasic.order;

import com.example.corebasic.discount.DiscountPolicy;
import com.example.corebasic.member.Member;
import com.example.corebasic.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    /*
     초기 설계에서는 MemberRepository, DiscountPolicy 인터페이스의 구현체인 MemoryMemberRepository, FixDiscountPolicy 를 직접 생성하여 사용
     private final MemberRepository memberRepository = new MemoryMemberRepository();
     private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

     새로운 할인 정책(RateDiscountPolicy)을 적용하기 위해 DiscountPolicy 의 구현체를 변경
     private final MemberRepository memberRepository = new MemoryMemberRepository();
     private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

     클라이언트의 소스도 변경이 발생해야함 -> OCP 원칙 위반
     인터페이스 뿐만 아니라 구현체까지 의존함 -> DIP 원칙 위반
     OrderServiceImpl 에서 MemberRepository, DiscountPolicy 의 구현체가 아닌 인터페이스에만 의존하게끔 변경 -> DIP 원칙 준수
    */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /*
     그러나 구현체 없이 인터페이스만으로 로직을 실행하면 NullPointerException 이 발생
     외부에서 클라이언트(OrderServiceImpl)에 필요한 의존성(DiscountPolicy) 구현 객체를 대신 생성하고 주입하면 문제를 해결할 수 있음
     생성지를 통해 MemberRepository, DiscountPolicy 의 구현체(의존성)를 받아와서(주입) 사용함 -> 생성자를 통한 의존성 주입
    */
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // OrderServiceImpl 는 어떤 구현체를 사용하게 될지 알고있을 필요 없이 본인의 역할만 수행하면됨

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        /*
         다형성에 의해서 각 인터페이스(MemberRepository, DiscountPolicy) 구현체의 함수(save, discount)가 실행되며,
         설정 정보 혹은 로그를 확인해야만 실행 시 어떤 구현체가 사용되는지 알수있음
        */
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}