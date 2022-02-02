package com.example.corebasic;

import com.example.corebasic.member.Grade;
import com.example.corebasic.member.Member;
import com.example.corebasic.member.MemberService;
import com.example.corebasic.order.Order;
import com.example.corebasic.order.OrderService;

// OrderService 사용 예제, 순수 Java Code
public class OrderApp {
    public static void main(String[] args) {
        /*
         초기 설계에서는 MemberService, OrderService 인터페이스의 구현체인 MemberServiceImpl, OrderServiceImpl 를 직접 생성하여 사용
         MemberService memberService = new MemberServiceImpl();
         OrderService orderService = new OrderServiceImpl();

         관심사의 분리(스프링 없는 순수 Java DI 컨테이너 구현)
         AppConfig 에 의해 생성된 MemberService, OrderService 구현체를 사용
        */
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        // Member 생성
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // orderService 주문 생성
        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);
    }
}