package com.tu.goodsbuy.controller.user.get;


import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping("/email-auth") //임시 테스트용
    public String getEmailAuthPage() {
        return "emailauth";
    }
}
