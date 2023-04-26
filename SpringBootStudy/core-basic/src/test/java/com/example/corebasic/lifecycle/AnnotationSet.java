package com.example.corebasic.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// 애노테이션 @PostConstruct, @PreDestroy
public class AnnotationSet extends NetworkClient {
    public AnnotationSet() {
        System.out.println("생성자 호출(객체 생성): " + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("AnnotationSet.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("AnnotationSet.close");
        disconnect();
    }
}