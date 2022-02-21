package com.example.corebasic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/*
 스프링 컨테이너는 @Configuration 이 붙은 클래스를 애플리케이션의 설정(구성) 정보로 사용
 @Configuration 내부적으로 @Component 을 포함함으로 컴포넌트 스캔의 대상이 되어 스프링 빈으로 등록됨
*/
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
/*
 @ComponentScan 는 @Component 이 붙은 클래스를 전부 찾아서(스캔해서) 스프링 빈으로 등록해줌

 AppConfig, TestConfig 등 앞서 만들어두었던 설정 정보(@Configuration)도 함께 등록, 실행되어 버림
 excludeFilters 를 이용해서 설정 정보(@Configuration)는 컴포넌트 스캔 대상에서 제외
 보통 설정 정보를 컴포넌트 스캔 대상에서 제외하지는 않음
*/
public class AutoAppConfig {
}