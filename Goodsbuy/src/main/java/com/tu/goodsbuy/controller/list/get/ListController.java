package com.tu.goodsbuy.controller.list.get;

import com.tu.goodsbuy.controller.param.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/goodsbuy")
public class ListController {


    @GetMapping(value = {" ", "/", "/list"})
    public String list() {
        return "list";
    }





}
