package com.example.corebasic.singleton;

// 애플리케이션에 영향이 가지 않게끔 test 에 작성
public class SingletonService {
    // static 변수는 클래스 레벨에 존재함으로 딱 하나만 존재, 객체 instance 를 미리 하나 생성해서 올려둠
    private static final SingletonService instance = new SingletonService();

    /*
     클래스의 인스턴스가 필요한 경우 public static 으로 선언된 getInstance 메서드를 통해서만 조회하도록 허용
     메서드 호출 시, 항상 같은 인스턴스를 반환
    */
    public static SingletonService getInstance() {
        return instance;
    }

    /*
     생성자를 private 으로 선언하여 외부에서 new 키워드를 사용한 객체 생성을 방지
     생성자 호출 시, 컴파일 오류 발생
    */
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}