package com.example.introduction.repository;

import com.example.introduction.domain.Member;

import java.util.*;

/*
 MemberRepository는 저장소로서 수행해야할 역할(save, findById, findByName, findAll)을 정의
 Optional은 자바 8에 추가된 기능으로 null을 효율적으로 다루기 위해 사용
*/
public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
