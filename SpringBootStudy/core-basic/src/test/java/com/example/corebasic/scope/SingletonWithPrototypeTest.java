package com.example.corebasic.scope;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototypeTest {
    AnnotationConfigApplicationContext ac;

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public int addCount() {
            count++;
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }

    @Test
    @DisplayName("직접 프로토타입 빈 요청")
    void directRequest() {
        ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        for (int i = 0; i < 3; i++) {
            PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class);
            System.out.println("prototypeBean = " + prototypeBean);
            assertThat(prototypeBean.addCount()).isEqualTo(1);
        }
    }

    @Scope("singleton")
    @RequiredArgsConstructor
    static class Client {
        private final PrototypeBean prototypeBean; // 생성 시점에 주입

        public int logic() {
            System.out.println("prototypeBean = " + prototypeBean);
            return prototypeBean.addCount();
        }
    }

    @Test
    @DisplayName("싱글톤 빈에서 프로토타입 빈 요청")
    void requestWithSingletonClient() {
        ac = new AnnotationConfigApplicationContext(Client.class, PrototypeBean.class);
        for (int i = 0; i < 3; i++) assertThat(ac.getBean(Client.class).logic()).isEqualTo(i + 1);
    }

    @Scope("singleton")
    @RequiredArgsConstructor
    static class ClientApplicationContext {
        private final ApplicationContext ac;

        public int logic() {
            PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class);
            System.out.println("prototypeBean = " + prototypeBean);
            return prototypeBean.addCount();
        }
    }

    @Test
    @DisplayName("ApplicationContext.getBean()를 이용하여 프로토타입 빈 요청")
    void requestWithApplicationContext() {
        ac = new AnnotationConfigApplicationContext(ClientApplicationContext.class, PrototypeBean.class);
        for (int i = 0; i < 3; i++) assertThat(ac.getBean(ClientApplicationContext.class).logic()).isEqualTo(1);
    }

    @Scope("singleton")
    @RequiredArgsConstructor
    static class ClientObjectProvider {
        private final ObjectProvider<PrototypeBean> prototypeBeanProvider;

        public int logic() {
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            System.out.println("prototypeBean = " + prototypeBean);
            return prototypeBean.addCount();
        }
    }

    @Test
    @DisplayName("ObjectProvider.getObject()를 이용하여 프로토타입 빈 요청")
    void requestWithObjectProvider() {
        ac = new AnnotationConfigApplicationContext(ClientObjectProvider.class, PrototypeBean.class);
        for (int i = 0; i < 3; i++) assertThat(ac.getBean(ClientObjectProvider.class).logic()).isEqualTo(1);
    }

    @Scope("singleton")
    @RequiredArgsConstructor
    static class ClientInjectProvider {
        private final Provider<PrototypeBean> provider;

        public int logic() {
            PrototypeBean prototypeBean = provider.get();
            System.out.println("prototypeBean = " + prototypeBean);
            return prototypeBean.addCount();
        }
    }

    @Test
    @DisplayName("InjectProvider.get() 를 이용하여 프로토타입 빈 요청")
    void requestWithInjectProvider() {
        ac = new AnnotationConfigApplicationContext(ClientInjectProvider.class, PrototypeBean.class);
        for (int i = 0; i < 3; i++) assertThat(ac.getBean(ClientInjectProvider.class).logic()).isEqualTo(1);
    }
}