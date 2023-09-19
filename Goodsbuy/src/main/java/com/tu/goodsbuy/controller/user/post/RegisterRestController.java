package com.tu.goodsbuy.controller.user.post;


import com.tu.goodsbuy.exception.EmailSendFailedException;
import com.tu.goodsbuy.service.EmailService;
import com.tu.goodsbuy.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;


@RequiredArgsConstructor
@RestController
public class RegisterRestController {


    private final UserService userService;
    private final EmailService emailService;

    @PostMapping("/users/id/duplicated")
    public ResponseEntity<Boolean> userIdCheck(@RequestBody Map<String, String> idMap) {

        String idToCheck = idMap.get("id");

        return ResponseEntity.ok(userService.isUserIdExists(idToCheck));
    }

    @PostMapping("/users/nickname/duplicated")
    public ResponseEntity<Boolean> userNickCheck(@RequestBody Map<String, String> nickNameMap) {

        String nickToCheck = nickNameMap.get("nickname");
        return ResponseEntity.ok(userService.isNicknameExists(nickToCheck));
    }

    @PostMapping("/email")
    public ResponseEntity<String> sendEmailCode(@RequestParam String email, HttpServletRequest request) {
        try {
            String sendCode = emailService.sendMessage(email);
            request.getSession().setAttribute("sendCode", sendCode);

        } catch (Exception e) {
            throw new EmailSendFailedException();
        }

        return ResponseEntity.ok("전송완료");
    }

    @PostMapping("/email-code")
    public ResponseEntity<String> checkEmailCode(@RequestParam String receiveCode, HttpServletRequest request) throws IOException {

        String sendCode = (String) request.getSession().getAttribute("sendCode");

        if (sendCode == null || !sendCode.equals(receiveCode)) {
            return ResponseEntity.ok("이메일 인증 코드가 일치하지 않습니다.");
        }
        request.getSession().removeAttribute("sendCode");



        return ResponseEntity.ok("이메일 인증에 성공하였습니다.");
    }


}
