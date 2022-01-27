package com.example.introduction.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
// Component 를 사용하여 빈으로 등록하거나 자바 설정 파일(SpringConfig)을 통해 빈으로 등록할 수 있음
public class TimeTraceAop {

    @Around("execution(* com.example.introduction..*(..))")
    // 적용 대상 지정
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed(); // 다음 메소드로 진행됨
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("End (" + joinPoint.toString() + ") " + timeMs + "ms");
        }
    }
}
