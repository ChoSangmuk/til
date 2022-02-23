package com.example.corebasic.scan.filter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.context.annotation.ComponentScan.Filter;

public class ComponentFilterAppConfigTest {
    @Test
    @DisplayName("ComponentScan의 Filter 테스트")
    void filterScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        // 컴포넌트 스캔에 포함된 클래스 조회
        assertThat(ac.getBean("beanInclude", BeanInclude.class)).isNotNull();

        // 컴포넌트 스캔에 제외된 클래스 조회
        assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanExclude", BeanExclude.class));
    }

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
            /*
             FilterType 옵션
             1. ANNOTATION : 기본값, 애노테이션을 인식해서 동작
               ex)  org.example.SomeAnnotation
             2. ASSIGNABLE_TYPE : 지정한 타입과 자식 타입을 인식해서 동작
               ex)  org.example.SomeClass
             3. ASPECTJ : AspectJ 패턴 사용
               ex)  org.example..*Service+
             4. REGEX : 정규 표현식
               ex)  org\.example\.Default.*
             5. CUSTOM : TypeFilter 이라는 인터페이스를 구현해서 처리
               ex)  org.example.MyTypeFilter

             예를 들어서 BeanInclude 도 제외하고 싶으면 다음과 같이 추가
             excludeFilters = {
                     @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class),
                     @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BeanInclude.class)
             }
            */
    )
    static class ComponentFilterAppConfig {
    }
}