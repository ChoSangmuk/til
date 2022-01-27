package com.example.todo101.persistence;

import java.util.List;

import com.example.todo101.model.TestEntity;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, String> {
  // JpaRepository 인터페이스, DB CRUD에 필요한 기본적인 인터페이스를 제공
  // 인터페이스에 대한 구현은 스프링 데이터 JPA가 대신 해줌
  // 스프링은 MethodInterceptor이라는 AOP 인터페이스를 사용한다.
  // MethodInterceptor는 JpaRepository의 메서드가 호출될 때,
  // 이를 가로채 메서드의 이름을 확인하고 메서드 이름을 기반으로 쿼리를 작성한다.

  // 기본적인 쿼리가 아닌 쿼리 1
  List<TestEntity> findByName(String name);

  // 기본적인 쿼리가 아닌 쿼리 2
  // @Query("select * from Todo t where t.userId=?1")
  // List<TestEntity> findByName(String name);
}
