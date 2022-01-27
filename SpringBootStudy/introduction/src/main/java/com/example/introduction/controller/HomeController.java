package com.example.introduction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    // 회원 가입, 조회 기능의 홈 화면 전달
    public String home() {
        return "home";
    }

}
