package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register() {
        return "register";
    }
}
