package com.example.introduction.service;

import com.example.introduction.domain.Member;
import com.example.introduction.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("Spring");

        // when
        Long saveId = memberService.join(member);

        // then 1
        assertThat(saveId).isEqualTo(member.getId());
        // then 2
        Member result = memberService.findOne(saveId).get();
        assertThat(result.getName()).isEqualTo(member.getName());
        // then 3
        result = memberRepository.findById(saveId).get();
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
        assertThat(result.getId()).isEqualTo(member1.getId());
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
        assertThat(result.getId()).isEqualTo(member1.getId());
    }
}