package com.tu.goodsbuy.controller.mypage.post;


import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.service.ProfileService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;


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
    public String updateProfile(HttpServletRequest request, @RequestParam MultipartFile file) {

//        MemberUser loginMember = (MemberUser) request.getSession().getAttribute("loginMember");
//        profileService.updateProfile(loginMember.getUserNo());

        if (!file.isEmpty()) {
            String fileName = profileService.uploadSaveImageAndGetIdentifier(profileImagePath, file);

        }


        return "redirect:/profile";
    }


}



