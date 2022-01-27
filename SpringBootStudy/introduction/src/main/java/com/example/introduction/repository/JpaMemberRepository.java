package com.example.introduction.repository;

import com.example.introduction.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

// MemberRepository 역할을 JPA 를 이용하여 구현
public class JpaMemberRepository implements MemberRepository {

    /*
     JPA 는 EntityManager 로 모든게 동작하며, 스프링이 설정 정보를 바탕으로 자동 생성됨
     따라서, Repository 는 만들어 진 EntityManager 를 생성자 주입을 통해 받아서 사용하기만 하면됨
     EntityManager 는 DB 연결과 이전에 사용한 DataSource 등을 내부적으로 포함
    */
    private final EntityManager entityManager;

    public JpaMemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Member save(Member member) {
        /*
         PK를 통한 CRUD 는 쿼리를 작성할 필요가 없음
         EntityManager(JPA)가 제공하는 persist 에 객체를 삽입하면 Insert SQL 을 만들어 DB에 삽입
         ID 값을 member 에 집어 넣어주는 것까지 진행
        */
        entityManager.persist(member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        /*
         PK를 통한 CRUD 는 쿼리를 작성할 필요가 없음
         EntityManager(JPA)가 제공하는 find 에 조회할 타입과 PK 값을 전달하면 Select SQL 을 만들어 DB 조회가 진행됨
         이전 단계인 JDBCTemplate 에서는 Mapper 를 통해 ResultSet 을 객체(Member)로 변경했음
        */
        Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    /*
     PK가 아닌 변수로 조회하는 경우 JPQL(객체 지향 쿼리 언어, SQL과 유사)를 이용해서 쿼리를 작성해주어야함
     SQL이 테이블을 대상으로 질의를 한다면, JPQL은 객체(엔티티)를 대상으로 질의를 진행
     또한 쿼리의 조회 컬럼 부분이 특정 변수가 아닌 객체 자체임, 기존에는 id, name을 받아서 맵핑했었음
    */
    public List<Member> findAll() {
        return entityManager
                .createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Optional<Member> findByName(String name) {
        return entityManager
                .createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findAny();
    }
}
