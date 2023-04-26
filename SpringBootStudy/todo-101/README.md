# React.js, 스프링 부트, AWS로 배우는 웹 개발 101 Todo

<a href="http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9791161755656&orderClick=LEa&Kc=">
  <img src="../Image/React.js, Spring Boot, AWS Web Development 101 cover.jpg" width="250" height="50%">
</a>

## 프로젝트 생성
- https://start.spring.io/ 
- Gradle Project
- Java 11
- Spring Boot 2.6.2
- jar
- Dependencies
  - Spring Web
  - Spring Data JPA
  - H2 Database
  - Lombok
  - Spring Boot DevTools
  - Spring Security
  - JJWT

## 프로젝트 실행 & JAR 파일 생성
```sh
./gradlew bootRun

./gradlew build 
java -jar build/libs/todo-101-0.0.1-SNAPSHOT.jar
```

## 프로젝트 구성/ 주요 소스 등 기타 핵심 사항 내용은 주석을 통해 명시 추가 필요