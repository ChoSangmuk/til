package com.example.introduction.domain;

import javax.persistence.*;

@Entity
// 회원 데이터를 정의하는 객체
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 데이터를 구분하기 위해 시스템에서 사용

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
