package com.example.corebasic.scan;

import com.example.corebasic.AutoAppConfig;
import com.example.corebasic.discount.DiscountPolicy;
import com.example.corebasic.discount.FixDiscountPolicy;
import com.example.corebasic.discount.RateDiscountPolicy;
import com.example.corebasic.member.MemberRepository;
import com.example.corebasic.member.MemberService;
import com.example.corebasic.order.OrderService;
import com.example.corebasic.order.OrderServiceImpl;
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
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderService orderService = ac.getBean(OrderService.class);
        System.out.println("orderService = " + orderService);
        assertThat(orderService).isInstanceOf(OrderService.class);

        MemberRepository memberRepository = ac.getBean(MemberRepository.class);
        System.out.println("memberRepository = " + memberRepository);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("조회 빈이 2개 이상인 경우 테스트")
    // 조회 빈이 2개 이상 - 문제와 @Qualifier, @Primary 의 우선 순위 확인을 위해 추가
    void noUniqueBeanTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        // 2개의 DiscountPolicy(RateDiscountPolicy, FixDiscountPolicy) 가 등록되어 있지만
        // FixDiscountPolicy 가 @Primary 로 지정되어 있음으로 FixDiscountPolicy 를 가져옴
        DiscountPolicy discountPolicy = ac.getBean(DiscountPolicy.class);
        System.out.println("discountPolicy = " + discountPolicy);
        assertThat(discountPolicy).isInstanceOf(FixDiscountPolicy.class);

        // OrderServiceImpl 에서 생성자 의존관계 자동 주입(@Autowired) 시 @MainDiscountPolicy(Qualifier) 가 사용되었음으로 RateDiscountPolicy 를 가져옴
        OrderServiceImpl orderServiceImpl = ac.getBean(OrderServiceImpl.class);
        System.out.println("orderServiceImpl.getDiscountPolicy() = " + orderServiceImpl.getDiscountPolicy());
        assertThat(orderServiceImpl.getDiscountPolicy()).isInstanceOf(RateDiscountPolicy.class);
    }
}