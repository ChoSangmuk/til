package com.example.corebasic.xml;

import com.example.corebasic.member.MemberService;
import com.example.corebasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// XmlAppConfig 테스트 코드
class XmlAppContextTest {
    @Test
    @DisplayName("XML 기반 스프링 빈 설정")
    void xmlAppContext() {
        /*
         GenericXmlApplicationContext 에 XML 설정 파일 전달
         Java Annotation 사용 시, AnnotationConfigApplicationContext 에 AppConfig.class 파일 전달
        */
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}