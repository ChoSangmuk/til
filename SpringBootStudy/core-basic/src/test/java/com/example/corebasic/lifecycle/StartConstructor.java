package com.example.corebasic.lifecycle;

// 빈 생명주기 콜백 시작 (생성자에서 초기화 진행)
public class StartConstructor extends NetworkClient {
    public StartConstructor() {
        System.out.println("생성자 호출(객체 생성): " + url);
        connect();
        call("초기화 연결 메시지");
    }
}