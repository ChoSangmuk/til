package com.example.corebasic.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// 인터페이스 InitializingBean, DisposableBean
public class InterfaceSet extends NetworkClient implements InitializingBean, DisposableBean {
    public InterfaceSet() {
        System.out.println("생성자 호출(객체 생성): " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InterfaceSet.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InterfaceSet.destroy");
        disconnect();
    }
}