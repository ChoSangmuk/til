package com.example.corebasic.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("MainDiscountPolicy")
// Qualifier 를 바로 사용하는 경우, 컴파일 시점에 타입 체크가 안됨으로 애노테이션을 직접 정의
public @interface MainDiscountPolicy {
}