package com.tu.goodsbuy.controller;

import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserController {


    @GetMapping(value = "/login")
    public String login( @SessionAttribute(name = "loginMember", required = false) MemberUser loginMember) {
        return loginMember == null ? "login" : "list";
    }

    @PostMapping(value = "/login.do")
    public String doLogin(@SessionAttribute(name = "loginMember", required = false) MemberUser loginMember) {

        return loginMember == null ? "login" : "list";
    }


    @GetMapping(value = "/register")
    public String signUp() {
        return "register";
    }


    @PostMapping(value = "/register.do")
    public String registerDo() {


        return "login";
    }


}
