package com.example.corebasic.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
/*
 가짜 프록시 객체를 생성하게 끔 설정
      적용 대상이 클래스면 TARGET_CLASS
      적용 대상이 인터페이스면 INTERFACES
*/
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    // requestURL 은 빈이 생성되는 시점에는 알 수 없으므로, 외부에서 setter 로 입력
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    // 기대하는 공통 포멧: [UUID][requestURL] {message}
    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    /*
     빈이 생성되는 시점에 자동으로 @PostConstruct 초기화 메서드를 사용해서 UUID 를 생성해서 저장
     HTTP 요청 당 하나씩 생성되므로, UUID 를 저장해두면 다른 HTTP 요청과 구분할 수 있음
    */
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }

    @PreDestroy
    // 빈이 소멸되는 시점에 @PreDestroy 를 사용해서 종료 메시지를 생성
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }
}