package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LoginController {


    @PostMapping("/login.do")
    public String doLogin(String username, String password, Model model) {

        System.out.println(username);
        System.out.println(password);

        Long userNo = UserService.getINSTANCE().doLogin(username, password);

        if (userNo == -1L) {
            return "redirect:/login";
        }
        System.out.println("victory");
        return "redirect:/goodsbuy/list";
    }


}
