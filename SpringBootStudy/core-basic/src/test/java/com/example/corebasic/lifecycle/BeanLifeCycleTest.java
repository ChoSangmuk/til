package com.example.corebasic.lifecycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    private static ConfigurableApplicationContext ac;
    private static String URL = "http://hello-spring.dev";
    private static String WORK_MESSAGE = "NetworkClient 사용";

    @Configuration
    static class StartConstructorConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new StartConstructor();
            networkClient.setUrl(URL);
            System.out.println("[StartConstructor.networkClient]");
            return networkClient;
        }
    }

    @Test
    @DisplayName("빈 생명주기 콜백 시작 (생성자에서 초기화 진행)")
    public void StartConstructorTest() {
        ac = new AnnotationConfigApplicationContext(StartConstructorConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        client.call(WORK_MESSAGE);
        ac.close();
    }


    @Configuration
    static class StartInBeanConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new StartInBean();
            networkClient.setUrl(URL);
            networkClient.connect();
            networkClient.call("초기화 연결 메시지");
            System.out.println("[StartInBean.networkClient]");
            return networkClient;
        }
    }

    @Test
    @DisplayName("빈 생명주기 콜백 시작 (빈 생성 중 초기화 진행)")
    public void StartInBeanTest() {
        ac = new AnnotationConfigApplicationContext(StartInBeanConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        client.call(WORK_MESSAGE);
        ac.close();
    }


    @Configuration
    static class InterfaceSetConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new InterfaceSet();
            networkClient.setUrl(URL);
            System.out.println("[InterfaceSet.networkClient]");
            return networkClient;
        }
    }

    @Test
    @DisplayName("인터페이스 InitializingBean, DisposableBean")
    public void InterfaceSetTest() {
        ac = new AnnotationConfigApplicationContext(InterfaceSetConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        client.call(WORK_MESSAGE);
        ac.close();
    }


    @Configuration
    static class BeanSetConfig {
        @Bean(initMethod = "start", destroyMethod = "close")
        public BeanSet networkClient() {
            BeanSet networkClient = new BeanSet();
            networkClient.setUrl(URL);
            System.out.println("[BeanSet.networkClient]");
            return networkClient;
        }
    }

    @Test
    @DisplayName("빈 등록 초기화, 소멸 메서드 지정")
    public void BeanSetTest() {
        ac = new AnnotationConfigApplicationContext(BeanSetConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        client.call(WORK_MESSAGE);
        ac.close();
    }


    @Configuration
    static class AnnotationSetConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new AnnotationSet();
            networkClient.setUrl(URL);
            System.out.println("[AnnotationSet.networkClient]");
            return networkClient;
        }
    }

    @Test
    @DisplayName("애노테이션 @PostConstruct, @PreDestroy")
    public void AnnotationSetTest() {
        ac = new AnnotationConfigApplicationContext(AnnotationSetConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        client.call(WORK_MESSAGE);
        ac.close();
    }
}