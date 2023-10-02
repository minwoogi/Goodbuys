package com.tu.goodsbuy.controller.mypage.post;


import com.tu.goodsbuy.global.util.ScriptWriterUtil;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.service.ProfileService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Slf4j
@RequiredArgsConstructor
@Controller
public class UserProfilePostController {

    private final ProfileService profileService;

    @Value("${profileImage.upload.path}")
    private String profileImagePath;


    @PostMapping("/users/nickname")
    public String updateNickname(@RequestParam String nickname, @SessionAttribute("loginMember") MemberUser loginMember) {
        profileService.updateNickname(loginMember.getUserNo(), nickname);
        return "redirect:/profile";
    }

    @PostMapping("/profile/update.do")
    public String updateProfile(@SessionAttribute("loginMember") MemberUser loginMember,
                                @RequestParam(required = false) MultipartFile file,
                                @RequestParam String introduction, HttpServletResponse response) {

        profileService.setIntroductionByUserNo(introduction, loginMember.getUserNo());

        if (!file.isEmpty()) {
            String fileName = profileService.uploadSaveImageAndGetIdentifier(profileImagePath, file);
            profileService.setImgUrlByUserNo(fileName, loginMember.getUserNo());
        }

        return "redirect:/profile";
    }

    @PostMapping("/profile/location")
    public String updateLocation(@RequestParam String location, @SessionAttribute("loginMember") MemberUser loginMember) {
        profileService.setLocationByUserNo(location, loginMember.getUserNo());
        return "redirect:/profile/location";
    }


}



