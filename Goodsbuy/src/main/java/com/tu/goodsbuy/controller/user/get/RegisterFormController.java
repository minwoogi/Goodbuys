package com.tu.goodsbuy.controller.user.get;


import com.tu.goodsbuy.dto.MemberUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class RegisterFormController {

    @GetMapping("/register.do")
    public String getSession(@SessionAttribute(name = "loginMember", required = false) MemberUser user) {
        return user == null ? "register" : "list";
    }

    @GetMapping(value = "/register")
    public String getSesson(@SessionAttribute(name = "loginMember", required = false) MemberUser user) {
        return user == null ? "register" : "list";
    }
}
