package com.example.corebasic.beanfind;

import com.example.corebasic.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("(스프링 컨테이너에 등록된) 모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 스프링에 등록된 모든 빈 이름(String)의 배열
        for (String beanDefinitionName : beanDefinitionNames) { // (shortcut iter)
            Object bean = ac.getBean(beanDefinitionName); // 빈 이름으로 Bean 조회
            System.out.println("name=" + beanDefinitionName + " object=" + bean); // (shortcut sout)
        }
//        System.out.println("\nJava8");
//        Arrays.stream(ac.getBeanDefinitionNames())
//                .forEach(v -> System.out.println("name=" + v + " object=" + ac.getBean(v)));
    }

    @Test
    @DisplayName("(내가 등록한) 애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // Bean 정보 조회
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name=" + beanDefinitionName + " object=" + bean);
            }
        }
//        System.out.println("\nJava8");
//        Arrays.stream(ac.getBeanDefinitionNames())
//                .filter(v -> ac.getBeanDefinition(v).getRole() == BeanDefinition.ROLE_APPLICATION)
//                .forEach(_v -> System.out.println("name=" + _v + " object=" + ac.getBean(_v)));
    }
}