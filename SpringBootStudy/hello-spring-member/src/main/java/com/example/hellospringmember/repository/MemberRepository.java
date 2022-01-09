package com.example.hellospringmember.repository;

import com.example.hellospringmember.domain.Member;

import java.util.*;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
