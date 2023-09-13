package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.controller.param.RegisterForm;
import com.tu.goodsbuy.service.EmailService;
import com.tu.goodsbuy.service.ProfileService;
import com.tu.goodsbuy.service.UserService;
import com.tu.goodsbuy.util.ScriptWriterUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;
    private final ProfileService profileService;
    private final EmailService emailService;


    @PostMapping("/register.do")
    public String doRegister(@Valid RegisterForm registerForm, BindingResult br, RedirectAttributes rttr, HttpServletResponse response) throws IOException {

        if (br.hasErrors()) {
            rttr.addFlashAttribute("registerForm", registerForm);
            rttr.addFlashAttribute("errors", br);
            return "redirect:/register";
        }

        if (userService.isValidRegister(registerForm.getUserId())) {
            userService.makeMemberUser(registerForm.getUserId(), registerForm.getUserPwd());
            profileService.makeMemberProfile(registerForm.getUserId(), registerForm.getNickname());
        } else {
            ScriptWriterUtil.writeAndRedirect(response, "이미 존재하는 ID입니다.", "/register");
        }

        ScriptWriterUtil.writeAndRedirect(response, "회원가입에 성공하였습니다.", "/login");

        return "redirect:/goodsbuy/list";
    }

    @PostMapping("/email-auth")
    public String doAutoEmail(@RequestParam String email) throws Exception {

        String confirm = emailService.sendSimpleMessage(email);



        System.out.println("전송완료!");

        return "/eamilauth";
    }


}
