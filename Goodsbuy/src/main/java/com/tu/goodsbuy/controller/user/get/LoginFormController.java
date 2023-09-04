package com.tu.goodsbuy.controller.user.get;

import com.tu.goodsbuy.dto.MemberUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class LoginFormController {


    @GetMapping(value = "/login")
    public String redirectLoginPage(@SessionAttribute(name = "loginMember", required = false) MemberUser user) {
        return user == null ? "login" : "redirect:/goodsbuy/list";
    }


    @GetMapping(value = "/login.do")
    public String redirectToList(@SessionAttribute(name = "loginMember", required = false) MemberUser user) {
        return user == null ? "login" : "/goodsbuy/list";
    }


}
