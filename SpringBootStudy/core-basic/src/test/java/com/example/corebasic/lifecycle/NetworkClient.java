package com.example.corebasic.lifecycle;

public class NetworkClient {
    protected String url;

    // 외부 네트워크 URL 설정
    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect(초기화 작업): " + url);
    }

    // 서비스 호출
    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close(종료 작업): " + url);
    }
}