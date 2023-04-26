package com.example.corebasic.web;

import com.example.corebasic.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;

    public void logic(String id) {
        System.out.println("LogDemoService.myLogger = " + myLogger.getClass());
        // Logic 처리(1초)가 있다고 가정
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        myLogger.log("service id = " + id);
    }
}