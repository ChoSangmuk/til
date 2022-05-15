package com.example.corebasic;

import com.example.corebasic.member.Grade;
import com.example.corebasic.member.Member;
import com.example.corebasic.member.MemberService;
import com.example.corebasic.order.Order;
import com.example.corebasic.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// OrderService 사용 예제, 순수 Java Code
public class OrderApp {
    public static void main(String[] args) {
        /*
         초기 설계에서는 MemberService, OrderService 인터페이스의 구현체인 MemberServiceImpl, OrderServiceImpl 를 직접 생성하여 사용
         MemberService memberService = new MemberServiceImpl();
         OrderService orderService = new OrderServiceImpl();

         관심사의 분리(스프링 없는 순수 Java DI 컨테이너 구현)
         AppConfig 에 의해 생성된 MemberService, OrderService 구현체를 사용
         AppConfig appConfig = new AppConfig();
         MemberService memberService = appConfig.memberService();
         OrderService orderService = appConfig.orderService();

         스프링으로 전환하기
         AppConfig 의 애플리케이션 설정 정보를 삽입하여 ApplicationContext 생성
            ApplicationContext 가 곧 스프링 컨테이너로 스프링 빈을 관리하며, 스프링의 모든 동작이 ApplicationContext 를 통해 이루어짐
            AnnotationConfigApplicationContext 는 ApplicationContext 인터페이스의 구현체
            다형성이 적용되어 AnnotationConfigApplicationContext(Java Annotation) 이외에도 여러 형태를 가진 구현체가 존재
        */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        /*
         기존에는 개발자가 AppConfig 에 정의한 메소드를 직접 자바 코드로 호출하여 객체를 불러왔다면, 스프링 컨테이너가 제공하는 메소드를 통해 스프링 빈을 사용하도록 변경됨
            ApplicationContext.getBean(빈 이름, 반환 타입)
            @Configuration 클래스 안에서 @Bean 이 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록
            등록된 객체를 스프링 빈이라 하며, 메서드 이름을 스프링 빈의 이름으로 사용(memberService, orderService 등)
        */
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        // Member 생성
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // orderService 주문 생성
        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);
    }
}