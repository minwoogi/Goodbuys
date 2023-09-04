package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequiredArgsConstructor
@SessionAttributes({"loginMember"})
public class LoginController {


    private final UserService userService;

    @PostMapping("/login")
    public String doLogin(String username, String password, Model model) {

        MemberUser loginMember = userService.doLogin(username, password);

        if (loginMember == null) {
            model.addAttribute("msg", "계정 혹은 비밀번호가 일치하지 않습니다. 입력한 내용을 다시 확인해 주세요.");
            return "/login";
        }
        model.addAttribute("loginMember", loginMember);

        return "redirect:/goodsbuy/list";
    }


}
