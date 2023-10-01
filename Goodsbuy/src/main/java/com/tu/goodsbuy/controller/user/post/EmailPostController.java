package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.global.util.ScriptWriterUtil;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.service.ProfileService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
@Slf4j
public class EmailPostController {

    private final ProfileService profileService;

    @PostMapping("/check-email") // 인증 완료
    public String checkEmailCode(HttpServletRequest request, HttpServletResponse response) throws IOException {


        if (!(Boolean) request.getSession().getAttribute("emailAuth")) {
            ScriptWriterUtil.writeAndRedirect(response, "email 인증을 완료하지 않았습니다.", "/");
        }

        request.getSession().removeAttribute("emailAuth");
        return "redirect:/goodsbuy/list";
    }


    @PostMapping("/email-code") // 인증번호 확인
    public void checkEmailCode(@RequestParam String receiveCode,
                               HttpServletRequest request, HttpServletResponse response) throws IOException {

        String sendCode = (String) request.getSession().getAttribute("sendCode");
        String sendEmail = (String) request.getSession().getAttribute("sendEmail");

        if (sendCode == null) {
            ScriptWriterUtil.writeAndRedirect(response, "이메일 인증 유효시간을 초과하였습니다.", "/profile");
        }

        if (!sendCode.equals(receiveCode)) {
            ScriptWriterUtil.writeAndRedirect(response, "이메일 인증 코드가 일치하지 않습니다.", "/email");
        }


        profileService.setEmailVerificationStatus(
                ((MemberUser) request.getSession().getAttribute("loginMember")).getUserNo());
        request.getSession().removeAttribute("sendCode");
        request.getSession().setAttribute("emailAuth", true);


        profileService.setEmailProfileByUserNo(sendEmail,
                ((MemberUser) request.getSession().getAttribute("loginMember")).getUserNo());
        request.getSession().removeAttribute("sendEmail");
        ScriptWriterUtil.writeAndRedirect(response, "이메일 인증에 성공하였습니다.", "/goodsbuy/list");
    }


}
