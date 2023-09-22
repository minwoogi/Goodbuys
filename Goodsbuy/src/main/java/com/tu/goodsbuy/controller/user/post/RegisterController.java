package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.controller.param.RegisterForm;
import com.tu.goodsbuy.service.ProfileService;
import com.tu.goodsbuy.service.UserService;
import com.tu.goodsbuy.global.util.ScriptWriterUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;
    private final ProfileService profileService;


    @PostMapping("/register.do")
    public String doRegister(@Valid RegisterForm registerForm, BindingResult br, RedirectAttributes retry,
                             HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (br.hasErrors()) {
            retry.addFlashAttribute("registerForm", registerForm);
            retry.addFlashAttribute("errors", br);
            return "redirect:/register";
        }

        if (userService.isValidRegister(registerForm.getUserId(), registerForm.getNickname())) {
            userService.makeMemberUser(registerForm.getUserId(), registerForm.getUserPwd());
            profileService.makeMemberProfile(registerForm.getUserId(), registerForm.getNickname());
        } else {
            ScriptWriterUtil.writeAndRedirect(response, "ID나 NICKNAME 중복을 확인하세요.", "/register");
        }

        ScriptWriterUtil.writeAndRedirect(response, "회원가입에 성공하셨습니다", "/login");

        return "/login";
    }





}
