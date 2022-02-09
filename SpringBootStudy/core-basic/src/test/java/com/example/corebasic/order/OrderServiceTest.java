package com.example.corebasic.order;

import com.example.corebasic.AppConfig;
import com.example.corebasic.member.Grade;
import com.example.corebasic.member.Member;
import com.example.corebasic.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// OrderService 테스트 코드
class OrderServiceTest {
    /*
     초기 설계에서는 MemberService, OrderService 인터페이스의 구현체인 MemberServiceImpl, OrderServiceImpl 를 직접 생성하여 사용
     MemberService memberService = new MemberServiceImpl();
     OrderService orderService = new OrderServiceImpl();

     관심사의 분리(스프링 없는 순수 Java DI 컨테이너 구현)
     AppConfig 에 의해 생성된 MemberService, OrderService 구현체를 사용
    */
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
        this.orderService = appConfig.orderService();
    }

    @Test
    @DisplayName("VIP 주문 생성 테스트")
    void createOrder() {
        // given
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}