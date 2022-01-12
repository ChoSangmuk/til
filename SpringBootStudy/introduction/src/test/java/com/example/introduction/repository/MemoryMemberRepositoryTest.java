package com.example.introduction.repository;

import com.example.introduction.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member();
        member.setName("Spring");

        // when
        memoryMemberRepository.save(member);

        // then
        Member result = memoryMemberRepository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findByName() {
        // given
        Member member1 = new Member();
        member1.setName("Spring1");
        memoryMemberRepository.save(member1);
        Member member2 = new Member();
        member2.setName("Spring2");
        memoryMemberRepository.save(member2);

        // when
        Member result = memoryMemberRepository.findByName("Spring1").get();

        // then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member();
        member1.setName("Spring1");
        memoryMemberRepository.save(member1);
        Member member2 = new Member();
        member2.setName("Spring2");
        memoryMemberRepository.save(member2);

        // when
        List<Member> result = memoryMemberRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
    }
}