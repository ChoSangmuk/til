# Building a RESTful Web Service

- https://spring.io/guides/gs/rest-service/

## 프로젝트 생성
- https://start.spring.io/ 
- Maven Project
- Java 11
- Spring Boot 2.6.2
- jar
- Dependencies
  - Spring Web

## 프로젝트 실행
```sh
./mvnw spring-boot:run

# if Using Gradle
./gradlew bootRun
```

## 주요 소스
```java
// package com.example.basicrestservice;
// import something;

@RestController
public class GreetingController {
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
}
```
- In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller. 
  - The @RestController annotation tells Spring that this code describes an endpoint that should be made available over the web. 
  - It is shorthand for including both @Controller and @ResponseBody.
- @RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method. If the name parameter is absent in the request, the defaultValue of "World" is used.
- Spring Boot application uses the Jackson JSON library to automatically marshal(정렬) instances of type Object into JSON. 
  - Jackson is included by default by the web starter dependencies.
  - Thanks to Spring’s HTTP message converter support, you need not do this conversion manually. 
  - Spring’s MappingJackson2HttpMessageConverter is automatically chosen to convert the Object instance to JSON.

## JAR 파일 생성
- You can build a single executable JAR file that contains all the necessary dependencies, classes, and resources and run that. 
```sh
./mvnw clean package 
java -jar target/basic-rest-service-0.1.0.jar

# if Using Gradle
./gradlew build 
java -jar build/libs/basic-rest-service-0.1.0.jar
```