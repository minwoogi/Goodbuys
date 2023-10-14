package com.tu.goodsbuy.controller.mypage.post;


import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.service.ChatService;
import com.tu.goodsbuy.service.ProfileService;
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
    private final ChatService chatService;

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
                                @RequestParam String introduction) {

        profileService.setIntroductionByUserNo(introduction.trim(), loginMember.getUserNo());

        if (!file.isEmpty()) {
            //마이페이지  사진 업데이트
            profileService.deleteImage(
                    profileImagePath, profileService.getMemberProfileByUserNo(loginMember.getUserNo()).getImageURL());
            String fileName = profileService.uploadSaveImageAndGetIdentifier(profileImagePath, file);
            profileService.setImgUrlByUserNo(fileName, loginMember.getUserNo());

            //채팅방 프로필 사진 업데이트

        }
        return "redirect:/profile";
    }

    @PostMapping("/profile/location")
    public String updateLocation(@RequestParam String location, @SessionAttribute("loginMember") MemberUser loginMember) {
        profileService.setLocationByUserNo(location, loginMember.getUserNo());
        return "redirect:/profile/location";
    }


}



