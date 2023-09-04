package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
@RequiredArgsConstructor
@SessionAttributes({"loginMember"})
public class LoginController {


    private final UserService userService;

    @PostMapping("/login.do")
    public String doLogin(String username, String password, Model model, RedirectAttributes rttr) {


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
