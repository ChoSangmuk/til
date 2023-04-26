package com.example.corebasic.beandefinition;

import com.example.corebasic.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;

class BeanDefinitionTest {
    /*
     ApplicationContext 에는 getBeanDefinition 가 정의되어있지 않음으로 인터페이스로 정의할 수 없음
     실제 빈 메타정보(BeanDefinition)를 직접 가져와 사용할 일은 거의 없음
    */
    AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
    GenericXmlApplicationContext gxac = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        System.out.println("\nAnnotationConfigApplicationContext");
        Arrays.stream(acac.getBeanDefinitionNames())
                .filter(v -> acac.getBeanDefinition(v).getRole() == BeanDefinition.ROLE_APPLICATION)
                .forEach(v -> System.out.println("beanDefinitionName=" + v + " beanDefinition=" + acac.getBeanDefinition(v)));
        System.out.println("\nGenericXmlApplicationContext");
        Arrays.stream(gxac.getBeanDefinitionNames())
                .filter(v -> gxac.getBeanDefinition(v).getRole() == BeanDefinition.ROLE_APPLICATION)
                .forEach(v -> System.out.println("beanDefinitionName=" + v + " beanDefinition=" + gxac.getBeanDefinition(v)));
    }
    /*
     - 스프링에 빈을 등록하는 여러 가지 방법이 있으며 크게 2가지 방식 사용
      - 직접 스프링 빈 등록 VS 팩토리 메소드 사용

     AnnotationConfigApplicationContext
     - Annotation 기반 설정의 경우 팩토리 메소드를 사용하여 스프링 빈을 등록함으로 빈에 대한 정보가 명확하지 않음
     - class 정보가 없음
     beanDefinitionName=appConfig beanDefinition=Generic bean: class [com.example.corebasic.AppConfig$$EnhancerBySpringCGLIB$$e2cafca3]; scope=singleton; abstract=false; lazyInit=null; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null
     beanDefinitionName=memberService beanDefinition=Root bean: class [null]; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=appConfig; factoryMethodName=memberService; initMethodName=null; destroyMethodName=(inferred); defined in com.example.corebasic.AppConfig
     beanDefinitionName=orderService beanDefinition=Root bean: class [null]; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=appConfig; factoryMethodName=orderService; initMethodName=null; destroyMethodName=(inferred); defined in com.example.corebasic.AppConfig
     beanDefinitionName=memberRepository beanDefinition=Root bean: class [null]; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=appConfig; factoryMethodName=memberRepository; initMethodName=null; destroyMethodName=(inferred); defined in com.example.corebasic.AppConfig
     beanDefinitionName=discountPolicy beanDefinition=Root bean: class [null]; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=appConfig; factoryMethodName=discountPolicy; initMethodName=null; destroyMethodName=(inferred); defined in com.example.corebasic.AppConfig
     
     GenericXmlApplicationContext
     - XML기반 설정의 경우 직접 스프링 빈을 등록함으로 빈에 대한 정보가 명확
     - factoryBeanName, factoryMethodName 이 없음
     beanDefinitionName=memberService beanDefinition=Generic bean: class [com.example.corebasic.member.MemberServiceImpl]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [appConfig.xml]
     beanDefinitionName=orderService beanDefinition=Generic bean: class [com.example.corebasic.order.OrderServiceImpl]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [appConfig.xml]
     beanDefinitionName=memberRepository beanDefinition=Generic bean: class [com.example.corebasic.member.MemoryMemberRepository]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [appConfig.xml]
     beanDefinitionName=discountPolicy beanDefinition=Generic bean: class [com.example.corebasic.discount.RateDiscountPolicy]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [appConfig.xml]
    */
}