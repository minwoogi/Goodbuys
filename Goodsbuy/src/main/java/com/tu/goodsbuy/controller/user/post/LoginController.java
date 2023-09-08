package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequiredArgsConstructor
@SessionAttributes({"loginMember"})
public class LoginController {


    private final UserService userService;

    @PostMapping("/login.do")
    public String doLogin(String username, String password, Model model) {


        MemberUser loginMember = userService.doLogin(username, password);
        model.addAttribute("loginMember", loginMember);

        return "redirect:/goodsbuy/list";
    }


    @PostMapping("/logOut.do")
    public String doLogOut(SessionStatus sessionStatus) {
        sessionStatus.setComplete();

        return "redirect:/goodsbuy/list";
    }


}
