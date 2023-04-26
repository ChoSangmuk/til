package com.example.corebasic.member;

import lombok.Getter;
import lombok.Setter;

@Getter
// Lombok @Getter 로 Getter 메소드 대체
@Setter
// Lombok @Setter 로 Setter 메소드 대체
public class Member {
    private Long id; // ID
    private String name; // 이름
    private Grade grade; // 등급

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}