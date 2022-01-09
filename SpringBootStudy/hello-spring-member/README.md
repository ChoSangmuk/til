# Inflearn (김영한) / 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술

- [Inflearn Lecture Dashboard](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard)

## 프로젝트 생성
- https://start.spring.io/ 
- Gradle Project
- Java 11
- Spring Boot 2.6.2
- jar
- Dependencies
  - Thymeleaf
  - Spring Web
  - Spring Boot DevTools
  - H2 Database
  - JDBC API -> Spring Data JPA

## 프로젝트 실행 & JAR 파일 생성
```sh
./gradlew bootRun

./gradlew build 
java -jar build/libs/hello-spring-member-0.0.1-SNAPSHOT.jar
```

## 프로젝트 구성/ 주요 소스 등 기타 핵심 사항 내용은 주석을 통해 명시 추가 필요

# H2 Database 사용 방법 추가 필요
- jdbc:h2:~/Documents/twil/SpringBootStudy/hello-spring-member/etc/test
- jdbc:h2:tcp://localhost/~/Documents/twil/SpringBootStudy/hello-spring-member/etc/test