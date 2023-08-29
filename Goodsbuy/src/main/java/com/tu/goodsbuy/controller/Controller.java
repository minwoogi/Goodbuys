package com.tu.goodsbuy.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/account/sign_in")
    public String login() {
        return "loginPage";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
