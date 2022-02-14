package com.example.corebasic;

import com.example.corebasic.discount.DiscountPolicy;
import com.example.corebasic.discount.RateDiscountPolicy;
import com.example.corebasic.member.MemberRepository;
import com.example.corebasic.member.MemberService;
import com.example.corebasic.member.MemberServiceImpl;
import com.example.corebasic.member.MemoryMemberRepository;
import com.example.corebasic.order.OrderService;
import com.example.corebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/*
 스프링 컨테이너는 @Configuration 이 붙은 클래스(AppConfig)를 애플리케이션의 설정(구성) 정보로 사용
 @Configuration 이 붙은 클래스(AppConfig)도 스프링 빈으로 등록
 스프링이 내부적으로 필요로 하는 여러 클래스도 빈으로 등록됨

 예상 함수 호출
 Call AppConfig.memberService -> Call AppConfig.memberRepository
 Call AppConfig.orderService -> Call AppConfig.memberRepository, Call AppConfig.discountPolicy
 Call AppConfig.memberRepository
 Call AppConfig.discountPolicy

 실제 함수 호출
 Call AppConfig.memberService -> Call AppConfig.memberRepository
 Call AppConfig.orderService -> Call AppConfig.discountPolicy

 Configuration 삭제 시, 싱글톤을 보장할 수 없음
*/
public class AppConfig {
    @Bean
    /*
     @Configuration 클래스 안에서 @Bean 이 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록
     등록된 객체를 스프링 빈이라 하며, 메서드 이름을 스프링 빈의 이름으로 사용(memberService, orderService 등)
    */
    public MemberService memberService() {
        /*
         초기 설계에서는 MemberServiceImpl 생성 시, MemoryMemberRepository 를 직접 생성하여 주입
         return new MemberServiceImpl(new MemoryMemberRepository());

         리팩터링 후, memberRepository()를 호출한 결과를 주입
        */
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        /*
         초기 설계에서는 OrderServiceImpl 생성 시, MemoryMemberRepository, FixDiscountPolicy 를 직접 생성하여 주입
         return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

         리팩터링 후, memberRepository()와 discountPolicy()를 호출한 결과를 주입
        */
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        // MemberRepository 역할은 MemoryMemberRepository 구현체로 설정
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        /*
         DiscountPolicy 역할은 FixDiscountPolicy 구현체로 설정
         return new FixDiscountPolicy();

         새로운 할인 정책 적용
         DiscountPolicy 역할은 RateDiscountPolicy 구현체로 설정
        */
        System.out.println("Call AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }
}