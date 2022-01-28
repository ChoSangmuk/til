package com.example.corebasic.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// MemberService 테스트 코드
class MemberServiceTest {
    // 초기 설계에서는 MemberService 인터페이스의 구현체인 MemberServiceImpl 를 직접 생성하여 사용
    MemberService memberService = new MemberServiceImpl();

    @Test
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