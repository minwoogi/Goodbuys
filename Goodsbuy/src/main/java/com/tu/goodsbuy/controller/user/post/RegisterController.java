package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.controller.param.RegisterForm;
import com.tu.goodsbuy.service.UserService;
import com.tu.goodsbuy.util.ScriptWriterUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;


    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public String register(@Valid RegisterForm registerForm, BindingResult br, RedirectAttributes rttr, HttpServletResponse response) throws IOException {

        System.out.println("pwd : " + registerForm.getUserPwd());

        if (br.hasErrors()) {
            rttr.addFlashAttribute("registerForm", registerForm);
            rttr.addFlashAttribute("errors", br);
            return "redirect:/register";
        }

        if (userService.isValidRegister(registerForm.getUserId())) {
            userService.makeMemberUser(registerForm.getUserId(), registerForm.getUserPwd());
            userService.makeMemberProfile(registerForm.getUserId(), registerForm.getNickname());
        } else {
            ScriptWriterUtil.writeAndRedirect(response, "이미 존재하는 ID입니다.", "/register");
        }

        ScriptWriterUtil.writeAndRedirect(response, "회원가입에 성공하였습니다.", "/login");

        return "redirect:/goodsbuy/list";
    }


}
