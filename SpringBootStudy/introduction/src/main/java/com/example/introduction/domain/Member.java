package com.example.introduction.domain;

import javax.persistence.*;

@Entity
/*
 회원 데이터를 정의하는 객체
 @Entity 어노테이션을 사용한 클래스는 JPA 가 관리하는 Entity 가 됨
*/
public class Member {

    @Id // Entity 에는 Primary Key 를 지정해 주어야하는데 @Id 어노테이션을 사용한 필드 변수가 PK가 됨
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 사용자에 의해 입력되는 값이 아닌 DB가 자동으로 생성하는 값임을 명시(값의 생성 전략을 명시)
    private Long id; // 데이터를 구분하기 위해 시스템에서 사용

//    @Column(name = "xxxxx")
//    /*
//     @Column 어노테이션이 붙은 변수는 DB 테이블의 컬럼과 1:1로 매칭됨
//     DB의 컬럼 명이 xxxxx인 경우 name을 지정해 줄 수 있음
//    */
    private String name; // 사용자가 직접 입력한 name

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
