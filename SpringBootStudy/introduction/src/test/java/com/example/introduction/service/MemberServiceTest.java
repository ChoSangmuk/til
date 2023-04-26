package com.example.introduction.service;

import com.example.introduction.domain.Member;
import com.example.introduction.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// MemberService 클래스에 대한 검증, 테스트 케이스
class MemberServiceTest {

    MemberService memberService; // = new MemberService(); // 최초 설계
    /*
     테스트간 독립성 보장을 위해 테스트마다 메모리를 비워주어야함, 이로 인해 MemoryMemberRepository를 직접 생성하고 AfterEach를 작성
     MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

     최초 설계 기준 시점에 MemberService는 new MemoryMemberRepository()를 이용하여 객체를 직접 생성함
     현재는 static으로 store를 선언하여 인스턴스간 변수가 공유됨, 하지만 memberService의 repo와 memoryMemberRepository는 서로 다른 객체임
     이는 테스트의 정확성에 대한 보증이 어려움으로 MemberService를 수정하고 BeforeEach를 작성
    */
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    /*
     @BeforeEach는 각 테스트가 실행되기 전에 매번 실행됨
     각 테스트가 실행되기 전 memberService를 생성, 이때 memoryMemberRepository를 생성해서 넣어줌
     memberService의 repo와 memoryMemberRepository가 서로 같은 객체임을 보장
    */
    void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    /*
     AfterEach 없이 BeforeEach 만 실행하는 경우, 테스트를 실패
     이는 static 자원의 경우, 인스턴스 간에 자원을 공유하게 됨으로 발생하는 문제
     매 테스트 마다 repository는 다르지만 store는 static임으로 여전히 그대로 존재
    */
    void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    /*
     회원 가입 테스트
     테스트 클래스에서는 메소드 명을 한글로 사용해도 큰 문제가 없음
    */
    void join() {
        // given
        Member member = new Member();
        member.setName("Spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member result = memberService.findOne(saveId).get();
        assertThat(result.getName()).isEqualTo(member.getName());
    }

    @Test
    /*
     회원 가입 실패(name 중복으로 인한 실패)
     단순히 정상 Flow(중복이 없는 회원가입 시도)를 확인하는 것도 중요하지만 예외 Flow(중복 name 값에 대한 예외 발생 여부)를 확인하는 것도 중요
    */
    void join_fail() {
        // given
        Member member = new Member();
        member.setName("Spring");
        memberService.join(member);

        // when - name 중복으로 인한 Exception이 발생하는 것이 개발 의도
        // try ... catch를 사용하여 예외를 검증하는 방법
//        try {
//            memberService.join(member);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("name already exists");
//        }
        // 번거로운 try ... catch 검증 대신 사용할 수 있는 방법
        IllegalStateException result = assertThrows(IllegalStateException.class, () -> memberService.join(member));

        // then - Exception Message 검증
        assertThat(result.getMessage()).isEqualTo("name already exists");
    }

    @Test
    void findMembers() {
        // given
        Member member1 = new Member();
        member1.setName("Spring1");
        memberService.join(member1);
        Member member2 = new Member();
        member2.setName("Spring2");
        memberService.join(member2);

        // when
        List<Member> result = memberService.findMembers();

        // then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findOneByName() {
        // given
        Member member1 = new Member();
        member1.setName("Spring1");
        memberService.join(member1);
        Member member2 = new Member();
        member2.setName("Spring2");
        memberService.join(member2);

        // when
        Member result = memberService.findOne("Spring1").get();

        // then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findOneById() {
        // given
        Member member1 = new Member();
        member1.setName("Spring1");
        memberService.join(member1);
        Member member2 = new Member();
        member2.setName("Spring2");
        memberService.join(member2);

        // when
        Member result = memberService.findOne(member1.getId()).get();

        // then
        assertThat(result).isEqualTo(member1);
    }

}