package com.example.corebasic.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // ElementType 에 따라 어디에 붙을지(클래스, 필드) 정해짐
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}