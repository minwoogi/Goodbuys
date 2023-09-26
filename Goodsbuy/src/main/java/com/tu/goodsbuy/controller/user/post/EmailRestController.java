package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.global.exception.EmailSendFailedException;
import com.tu.goodsbuy.service.EmailService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class EmailRestController {

    private final EmailService emailService;

    @PostMapping("/email") //이메일 전송
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


}

