package com.tu.goodsbuy.controller.user.get;

import com.tu.goodsbuy.dto.MemberUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class LoginFormController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String redirectLoginPage(@SessionAttribute(name = "loginMember", required = false) MemberUser user) {
        return user == null ? "login" : "/goodsbuy/list";
    }


}
