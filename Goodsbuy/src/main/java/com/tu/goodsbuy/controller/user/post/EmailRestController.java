package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.exception.EmailSendFailedException;
import com.tu.goodsbuy.service.EmailService;
import com.tu.goodsbuy.util.ScriptWriterUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class EmailRestController {

    private final EmailService emailService;

    @PostMapping("/email")
    public ResponseEntity<String> sendEmailCode(@RequestParam String email, HttpServletRequest request) {
        try {
            String sendCode = emailService.sendMessage(email);

            HttpSession sendCodeSession = request.getSession();
            sendCodeSession.setAttribute("sendCode", sendCode);
            sendCodeSession.setMaxInactiveInterval(180); //3분


        } catch (Exception e) {
            throw new EmailSendFailedException();
        }

        return ResponseEntity.ok("이메일 전송완료");
    }

    @PostMapping("/email-code")
    public ResponseEntity<String> checkEmailCode(@RequestParam String receiveCode,
                                                 HttpServletRequest request, HttpServletResponse response) throws IOException {


        String sendCode = (String) request.getSession().getAttribute("sendCode");

        if (sendCode == null) {
            ScriptWriterUtil.writeAndRedirect(response, "이메일 인증 유효시간을 초과하였습니다.", "/register");
            return ResponseEntity.ok("이메일 인증 유효시간을 초과하였습니다.");
        } else if (!sendCode.equals(receiveCode)) {
            return ResponseEntity.ok("이메일 인증 코드가 일치하지 않습니다.");
        }

        request.getSession().removeAttribute("sendCode");
        request.getSession().setAttribute("emailAuth", true);

        return ResponseEntity.ok("이메일 인증에 성공하였습니다.");
    }
}

