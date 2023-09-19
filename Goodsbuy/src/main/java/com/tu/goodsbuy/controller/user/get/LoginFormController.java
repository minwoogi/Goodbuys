package com.tu.goodsbuy.controller.user.get;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginFormController {


    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }


    @GetMapping(value = "/login.do")
    public String getList() {
        return "login";
    }

    @GetMapping("/logout.do")
    public String doLogOut() {
        return "redirect:/goodsbuy/list";
    }


}
