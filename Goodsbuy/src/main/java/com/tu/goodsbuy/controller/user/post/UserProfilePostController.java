package com.tu.goodsbuy.controller.user.post;


import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.service.ProfileService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Controller
public class UserProfilePostController {

    private final ProfileService profileService;


    @PostMapping("/profile/updateNick.do")
    public String updateNickname(@RequestParam String nickname, HttpServletRequest request) {

        MemberUser loginMember = (MemberUser) request.getSession().getAttribute("loginMember");
        profileService.updateNickname(loginMember.getUserNo(), nickname);

        return "redirect:/goodsbuy/profile";
    }

    @PostMapping("/profile/update.do")
    public String updateProfile(HttpServletRequest request) {

        MemberUser loginMember = (MemberUser) request.getSession().getAttribute("loginMember");
        profileService.updateProfile(loginMember.getUserNo());


        return "redirect:/goodsbuy/profile";
    }

}
