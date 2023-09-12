package com.tu.goodsbuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
public class GoodsBuyController {


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/errorPage")
    public String errorPage() {
        return "errorPage";
    }


}

