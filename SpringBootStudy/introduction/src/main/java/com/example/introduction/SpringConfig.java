package com.example.introduction;

import com.example.introduction.repository.*;
import com.example.introduction.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
/*
 스프링이 시작하는 시점에 해당 클래스의 @Bean 메소드를 이용하여 스프링 빈을 생성, 등록
 어떠한 구현체를 주입할지 개발자가 Java 코드로 설정할 수 있음

 @Configuration 을 사용하는 클래스(SpringConfig)도 스프링 빈이 됨
*/
public class SpringConfig {
    // JDBC, JDBCTemplate 을 사용하는 경우
    private final DataSource dataSource;
    // JPA를 사용하는 경우
    private final EntityManager em;
    // Spring Data JPA 를 사용하는 경우, MemberRepository 자체를 주입받음
    private final MemberRepository memberRepository;

    /*
     SpringConfig 클래스가 빈으로 생성되어질 때 SpringConfig 클래스의 생성자가 호출됨
     이때, 스프링이 설정 파일을 읽고 미리 생성해둔 DataSource, EntityManager 등의 의존성을 주입받아 사용할 수 있음

     학습의 편의성을 생각하여 통합 생성자를 만들어 둠, private 변수와 함께 사용
    */
    public SpringConfig(DataSource dataSource, EntityManager em, MemberRepository memberRepository) {
        this.dataSource = dataSource;
        this.em = em;
        this.memberRepository = memberRepository;
    }

    @Bean
    // 메소드를 실행하여 반환되는 객체를 스프링 빈에 등록
    MemberService memberService() {
//        // MemberService 는 생성자는 MemberRepository 구현체를 필요로 함
//        return new MemberService(memberRepository());
        // SpringDataJpaMemberRepository 를 사용하는 경우, 스프링이 MemberRepository 인스턴스 자체를 주입함으로 함수를 호출할 필요가 없음
        return new MemberService(memberRepository);
    }

//    @Bean
//    /*
//     메소드를 실행하여 반환되는 객체를 스프링 빈에 등록
//     SpringConfig 생성 시 주입된 DataSource를, EntityManager 등을 주입하여 생성
//    */
//    public MemberRepository memberRepository() {
//        //  MemoryMemberRepository 를 주요 구현체로 사용하는 경우
//        return new MemoryMemberRepository();
//        //  JdbcMemberRepository 를 주요 구현체로 사용하는 경우
//        return new JdbcMemberRepository(dataSource);
//        //  JdbcTemplateMemberRepository 를 주요 구현체로 사용하는 경우
//        return new JdbcTemplateMemberRepository(dataSource);
//        //  JpaMemberRepository 를 주요 구현체로 사용하는 경우
//        return new JpaMemberRepository(em);
//        //  SpringDataJpaMemberRepository 를 주요 구현체로 사용하는 경우
//        return memberRepository;
//    }
}
