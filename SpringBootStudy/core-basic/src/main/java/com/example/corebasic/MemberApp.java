package com.example.corebasic;

import com.example.corebasic.member.Grade;
import com.example.corebasic.member.Member;
import com.example.corebasic.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// MemberService 사용 예제, 순수 Java Code
public class MemberApp {
    public static void main(String[] args) {
        /*
         초기 설계에서는 MemberService 인터페이스의 구현체인 MemberServiceImpl 를 직접 생성하여 사용
         MemberService memberService = new MemberServiceImpl();

         관심사의 분리(스프링 없는 순수 Java DI 컨테이너 구현)
         AppConfig 에 의해 생성된 MemberService 구현체를 사용
         AppConfig appConfig = new AppConfig();
         MemberService memberService = appConfig.memberService();

         스프링으로 전환하기
         AppConfig 의 애플리케이션 설정 정보를 삽입하여 ApplicationContext 생성
         기존에는 개발자가 AppConfig 에 정의한 메소드를 직접 자바 코드로 호출하여 객체를 불러왔다면, 스프링 컨테이너가 제공하는 메소드를 통해 스프링 빈을 사용하도록 변경됨
        */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // Member 생성
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // Member 조회
        Member findMember = memberService.findMember(1L);

        // 생성 및 조회 확인
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}