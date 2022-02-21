package com.example.corebasic.scan;

import com.example.corebasic.AutoAppConfig;
import com.example.corebasic.discount.DiscountPolicy;
import com.example.corebasic.member.MemberRepository;
import com.example.corebasic.member.MemberService;
import com.example.corebasic.order.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {
    @Test
    @DisplayName("ComponentScan 테스트")
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderService orderService = ac.getBean(OrderService.class);
        System.out.println("orderService = " + orderService);
        System.out.println("orderService = " + orderService.getClass());
        assertThat(orderService).isInstanceOf(OrderService.class);

        MemberRepository memberRepository = ac.getBean(MemberRepository.class);
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("memberRepository = " + memberRepository.getClass());
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);

        DiscountPolicy discountPolicy = ac.getBean(DiscountPolicy.class);
        System.out.println("discountPolicy = " + discountPolicy);
        System.out.println("discountPolicy = " + discountPolicy.getClass());
        assertThat(discountPolicy).isInstanceOf(DiscountPolicy.class);
    }
}