package com.tu.goodsbuy.controller.user.get;


import com.tu.goodsbuy.dto.MemberProfile;
import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.service.ProfileService;
import com.tu.goodsbuy.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserProfileGetController {

    private final ProfileService profileService;

    @GetMapping("/goodsbuy/profile")
    public String myPage(HttpServletRequest request, Model model) {

        MemberUser loginMember = (MemberUser) request.getSession().getAttribute("loginMember");
        MemberProfile memberProfile = profileService.getMemberProfileByUserNo(loginMember.getUserNo());

        model.addAttribute("memberProfile", memberProfile);
        return "myPage";
    }
}
