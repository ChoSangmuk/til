package com.example.corebasic.lifecycle;

// 빈 생명주기 콜백 시작 (빈 생성 중 초기화 진행)
public class StartInBean extends NetworkClient {
    public StartInBean() {
        System.out.println("생성자 호출(객체 생성): " + url);
    }
}