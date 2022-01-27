package com.example.introduction.repository;

import com.example.introduction.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 MemberRepository 역할을 스프링 데이터 JPA 를 이용하여 구현 ...?
 지금까지는 MemberRepository 를 implements 하여 필요한 내용들을 직접 구현했었음
 
 Spring Data JPA 가 JpaRepository 를 상속받는 인터페이스의 구현체를 직접 생성하고 스프링 빈으로 등록함
 개발자는 그걸 그대로 가져다가 연결만 하면됨
*/
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
