package com.example.corebasic.web;

import com.example.corebasic.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;

    /*
     ObjectProvider 를 사용하면 HTTP 요청이 들어올 때까지 객체 생성을 미룰 수 있음
     private final ObjectProvider<MyLogger> myLoggerProvider;

     ObjectProvider 대신 MyLogger 에 proxyMode 를 지정하면 가짜 프록시 객체를 생성하여 의존성을 주입해 둠
     가짜 프록시 객체는 실제 로직이 필요한 순간이 되면 진짜 객체를 찾아 작업을 위임
    */
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        System.out.println("LogDemoController.myLogger = " + myLogger.getClass());

        myLogger.setRequestURL(request.getRequestURL().toString());
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}