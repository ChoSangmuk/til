package com.example.corebasic;

import com.example.corebasic.member.Grade;
import com.example.corebasic.member.Member;
import com.example.corebasic.member.MemberService;

// MemberService 사용 예제, 순수 Java Code
public class MemberApp {
    public static void main(String[] args) {
        /*
         초기 설계에서는 MemberService 인터페이스의 구현체인 MemberServiceImpl 를 직접 생성하여 사용
         MemberService memberService = new MemberServiceImpl();

         관심사의 분리(스프링 없는 순수 Java DI 컨테이너 구현)
         AppConfig 에 의해 생성된 MemberService 구현체를 사용
        */
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

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