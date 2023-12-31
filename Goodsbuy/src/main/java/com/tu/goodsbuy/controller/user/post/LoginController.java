package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.controller.param.LoginForm;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
@SessionAttributes({"loginMember"})
@Slf4j
public class LoginController {


    private final UserService userService;

    @PostMapping("/login.do")
    public String doLogin(@Valid LoginForm loginForm, BindingResult br, RedirectAttributes rttr, Model model) {

        if (br.hasErrors()) {
            if (!loginForm.getUsername().equals("choo")&& !loginForm.getUsername().equals("min"))  { // imsi 관리자 아이디
                rttr.addFlashAttribute("errors", br);
                return "redirect:/login";
            }
        }


        MemberUser loginMember = userService.doLogin(loginForm.getUsername(), loginForm.getPassword());
        model.addAttribute("loginMember", loginMember);

        return "redirect:/goodsbuy/list";
    }


    @PostMapping("/logout.do")
    public String doLogOut(SessionStatus sessionStatus) {
        sessionStatus.setComplete();

        return "redirect:/goodsbuy/list";
    }


}
