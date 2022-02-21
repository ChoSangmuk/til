package com.example.corebasic.order;

import com.example.corebasic.discount.DiscountPolicy;
import com.example.corebasic.member.Member;
import com.example.corebasic.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// ComponentScan 의 대상으로 지정하기 위해 @Component 를 추가
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

     ComponentScan 을 이용하여 스프링 빈을 등록하는 경우, 의존관계에 대한 명시가 없음
     @Autowired 를 생성자에 추가하면 스프링이 타입에 맞는 구현체를 찾아 의존관계를 자동으로 주입
     (@Component 을 사용하게 되면 자연스럽게 @Autowired 를 함께 사용하게 됨)

     ApplicationContext.getBean(MemberRepository.class)와 유사하게 동작한다고 생각하면 편함
     @Autowired 를 사용하면 생성자에서 여러 의존관계도 한번에 주입받을 수 있음
     생성자가 유일한 경우, 생략 가능
    */
    @Autowired
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

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}