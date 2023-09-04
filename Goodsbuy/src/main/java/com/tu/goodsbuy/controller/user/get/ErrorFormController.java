package com.tu.goodsbuy.controller.user.get;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorFormController {

    @RequestMapping("/errorPage")
    public String viewErrorPage(){

        return "errorPage";
    }


}
