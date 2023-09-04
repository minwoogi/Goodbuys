package com.tu.goodsbuy.controller.user.get;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/logOut.do")
public class LogOutController {


    @GetMapping
    public String doLogOut(SessionStatus sessionStatus) {

        sessionStatus.setComplete();
        return "redirect:/list";
    }


}
