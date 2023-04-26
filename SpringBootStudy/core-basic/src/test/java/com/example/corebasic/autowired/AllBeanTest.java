package com.example.corebasic.autowired;

import com.example.corebasic.AutoAppConfig;
import com.example.corebasic.discount.DiscountPolicy;
import com.example.corebasic.member.Grade;
import com.example.corebasic.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {
    @Test
    @DisplayName("조회한 빈이 모두 필요할 때 테스트")
    void BeanMapTest() {
        // new AnnotationConfigApplicationContext(클래스 정보) 를 통해 스프링 컨테이너를 생성
        // AutoAppConfig.class, DiscountService.class 를 파라미터로 넘겨 해당 클래스를 자동으로 스프링 빈으로 등록
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        assertThat(discountService).isInstanceOf(DiscountService.class);

        Member member = new Member(0L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member, 20000, "fixDiscountPolicy");
        assertThat(discountPrice).isEqualTo(1000);

        discountPrice = discountService.discount(member, 30000, "rateDiscountPolicy");
        assertThat(discountPrice).isEqualTo(3000);

        member = new Member(1L, "userB", Grade.BASIC);
        discountPrice = discountService.discount(member, 20000, "fixDiscountPolicy");
        assertThat(discountPrice).isEqualTo(0);

        discountPrice = discountService.discount(member, 30000, "rateDiscountPolicy");
        assertThat(discountPrice).isEqualTo(0);
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        // Map : Key - 스프링 빈의 이름, value - DiscountPolicy 타입으로 조회한 모든 스프링 빈
        // List : DiscountPolicy 타입으로 조회한 모든 스프링 빈
        // 만약 해당하는 타입의 스프링 빈이 없는 경우, 빈 컬렉션이나 Map 이 주입됨
        DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            System.out.println("policyMap = " + policyMap);
            this.policies = policies;
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            System.out.println(discountCode + " " + discountPolicy);
            return discountPolicy.discount(member, price);
        }
    }
}