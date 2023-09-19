package com.tu.goodsbuy.controller.mypage.get;


import com.tu.goodsbuy.model.dto.MemberProfile;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.service.ProfileService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserProfileGetController {

    private final ProfileService profileService;

    @GetMapping("/profile")
    public String getMyPage(HttpServletRequest request, Model model) {

        MemberUser loginMember = (MemberUser) request.getSession().getAttribute("loginMember");
        MemberProfile memberProfile = profileService.getMemberProfileByUserNo(loginMember.getUserNo());

        model.addAttribute("memberProfile", memberProfile);
        return "myPage";
    }
}
