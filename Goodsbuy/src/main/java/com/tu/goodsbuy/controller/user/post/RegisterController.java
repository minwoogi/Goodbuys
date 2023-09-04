package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;


    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public String register(String username, String password, RedirectAttributes rttr) {

        String idRegex = "^[a-zA-Z0-9]{4,20}$";
        String pwdRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%^&*()_+])[A-Za-z\\d@#$!%^&*()_+]{8,20}$";

        Pattern idPattern = Pattern.compile(idRegex);
        Pattern pwdPattern = Pattern.compile(pwdRegex);

        boolean isIdValid = idPattern.matcher(username).matches();
        boolean isPasswordValid = pwdPattern.matcher(password).matches();

        if (!isIdValid || !isPasswordValid) {
            rttr.addFlashAttribute("msg", "아이디 and 비밀번호 규칙에 맞게 입력해주세요");
            return "redirect:/register";
        }


        return "register";
    }
}
