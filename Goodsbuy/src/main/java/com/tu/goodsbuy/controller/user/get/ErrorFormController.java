package com.tu.goodsbuy.controller.user.get;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorFormController {

    @RequestMapping(value = "/errorPage", method = RequestMethod.GET)
    public String viewErrorPage() {

        return "errorPage";
    }


}
