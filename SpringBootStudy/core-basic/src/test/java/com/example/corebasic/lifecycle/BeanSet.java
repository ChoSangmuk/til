package com.example.corebasic.lifecycle;

// 빈 등록 초기화, 소멸 메서드 지정
public class BeanSet extends NetworkClient {
    public BeanSet() {
        System.out.println("생성자 호출(객체 생성): " + url);
    }

    public void start() {
        System.out.println("BeanSet.init");
        super.connect();
        super.call("초기화 연결 메시지");
    }

    public void close() {
        System.out.println("BeanSet.close");
        super.disconnect();
    }
}