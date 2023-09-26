package com.tu.goodsbuy.controller.user.get;

import com.tu.goodsbuy.model.dto.MemberProfile;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class EmailController {

    private final ProfileService profileService;

    @GetMapping("/email")
    public String getEmailAuthPage(@SessionAttribute(value = "loginMember", required = false) MemberUser memberUser,
                                   Model model) {

        if (Objects.nonNull(memberUser)) {
            MemberProfile memberProfile = profileService.getMemberProfileByUserNo(memberUser.getUserNo());
            model.addAttribute("emailCheck", memberProfile.getEmailCheck());
        }
        return "profile/emailauth";
    }
}
