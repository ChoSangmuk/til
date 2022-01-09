package com.example.hellospringmember.service;

import com.example.hellospringmember.domain.Member;
import com.example.hellospringmember.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    /**
     * BeforeEach 만 실행하는 경우, 역시 테스트 실패하게 되는데
     * 이는 static 자원의 경우, 인스턴스간에 자원을 공유하게 됨으로 발생하는 문제이다.
     *
     * 매 테스트 마다 repository는 다르지만 store는 static임으로 여전히 그대로 존재한다.
     */
    void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("Spring");

        // when
        Long saveId = memberService.join(member);

        // then
        assertThat(saveId).isEqualTo(member.getId());
        // then
        Member result = memberService.findOne(saveId).get();
        assertThat(result.getName()).isEqualTo(member.getName());
        // then
        result = memoryMemberRepository.findById(saveId).get();
        assertEquals(member.getName(), result.getName());
    }

    @Test
    void join_fail() {
        // given
        Member member = new Member();
        member.setName("Spring");
        memberService.join(member);

        // when
        IllegalStateException result = assertThrows(IllegalStateException.class, () -> memberService.join(member));
//        try {
//            memberService.join(member);
//            fail("failureMessage");
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("name already exists");
//        }

        // then
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