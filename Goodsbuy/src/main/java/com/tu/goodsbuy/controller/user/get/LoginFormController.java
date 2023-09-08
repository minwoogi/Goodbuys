package com.tu.goodsbuy.controller.user.get;

import com.tu.goodsbuy.dto.MemberUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class LoginFormController {


    @GetMapping(value = "/login")
    public String redirectLoginPage() {
        return "login";
    }


    @GetMapping(value = "/login.do")
    public String redirectToList() {
        return "login";
    }

    @GetMapping("/logOut.do")
    public String doLogOut() {

        return "redirect:/goodsbuy/list";
    }


}
