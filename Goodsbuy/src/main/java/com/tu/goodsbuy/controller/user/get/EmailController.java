package com.tu.goodsbuy.controller.user.get;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {

    @GetMapping("/email")
    public String getEmailAuthPage() {
        return "emailauth";
    }
}
