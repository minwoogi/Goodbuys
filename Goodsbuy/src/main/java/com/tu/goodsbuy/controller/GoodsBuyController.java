package com.tu.goodsbuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsBuyController {


    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
