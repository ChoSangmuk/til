package com.example.introduction.controller;

import com.example.introduction.domain.Member;
import com.example.introduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
/*
 클래스에 @Controller 을 사용하면 스프링이 시작하는 시점에 스프링 컨테이너를 통해 해당 객체(MemberController)를 생성, 관리하며 이를 스프링 빈이 관리된다고 표현함
 즉, 스프링 컨테이너가 관리하는 자바 객체를 빈(Bean) 혹은 스프링 빈이라 함
*/
public class MemberController {

    private final MemberService memberService;

    @Autowired
    /*
     생성자에 @Autowired 를 사용하면 객체 생성 시점에 해당 생성자를 실행하며, 실행에 필요한 스프링 빈(여기서는 MemberService)을 스프링 컨테이너에서 찾아서 연결(주입)해줌
     @Controller 가 존재하지 않는다면, 즉 스프링 빈에 등록하지 않고 직접 생성한 객체에서는 @Autowired 가 동작하지 않음
     생성자가 1개만 있으면 @Autowired 는 생략 가능
    */
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("members/new")
    // URL을 입력하는 경우, Get방식이 사용됨
    public String createMemberForm() {
        return "members/createMemberForm";
    }

    @PostMapping("members/new")
    // form에 정의된 action과 method(Post)를 바탕으로 회원가입 기능 구현
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("members")
    // 등록된 사용자 조회, Model을 사용하여 데이터 전달
    public String memberList(Model model) {
        model.addAttribute("members", memberService.findMembers());
        return "members/memberList";
    }

}
