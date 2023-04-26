# Spring Quick start Guide

- https://spring.io/quickstart

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
```

## 주요 소스
```java
// package com.example.quickstart;
// import something;

@SpringBootApplication
@RestController
public class QuickStartApplication {
  public static void main(String[] args) {
    SpringApplication.run(QuickStartApplication.class, args);
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }
}
```
- @SpringBootApplication is a convenience annotation that adds all of the following:
  - @Configuration: Tags the class as a source of bean definitions for the application context.
  - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. 
  - @ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.
- The @RestController annotation tells Spring that this code describes an endpoint that should be made available over the web. 
  - It is shorthand for including both @Controller and @ResponseBody.
- The @GetMapping("/hello") tells Spring to use our hello() method to answer requests that get sent to the http://localhost:8080/hello address. 
- The @RequestParam is telling Spring to expect a name value in the request, but if it’s not there, it will use the word "World" by default.
- Spring Boot’s embedded Apache Tomcat server is acting as a webserver and is listening for requests on localhost port 8080.