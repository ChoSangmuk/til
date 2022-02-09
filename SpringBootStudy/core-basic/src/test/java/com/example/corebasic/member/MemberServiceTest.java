package com.example.corebasic.member;

import com.example.corebasic.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// MemberService 테스트 코드
class MemberServiceTest {
    /*
     초기 설계에서는 MemberService 인터페이스의 구현체인 MemberServiceImpl 를 직접 생성하여 사용
     MemberService memberService = new MemberServiceImpl();

     관심사의 분리(스프링 없는 순수 Java DI 컨테이너 구현)
     AppConfig 에 의해 생성된 MemberService 구현체를 사용
    */
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
    }

    @Test
    @DisplayName("회원 가입 테스트")
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        assertThat(member).isEqualTo(findMember);
    }
}