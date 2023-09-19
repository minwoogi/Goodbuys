package com.tu.goodsbuy.controller.user.post;


import com.tu.goodsbuy.exception.EmailSendFailedException;
import com.tu.goodsbuy.service.EmailService;
import com.tu.goodsbuy.service.UserService;
import com.tu.goodsbuy.util.ScriptWriterUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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




}
