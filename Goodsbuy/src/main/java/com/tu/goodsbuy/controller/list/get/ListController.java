package com.tu.goodsbuy.controller.list.get;

import com.tu.goodsbuy.dto.MemberProfile;
import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.service.ProfileService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/goodsbuy")
public class ListController {

    private final ProfileService profileService;

    @GetMapping(value = {" ", "/", "/list"})
    public String list(HttpServletRequest request, Model model) {
        MemberUser memberUser = (MemberUser) request.getSession(false).getAttribute("loginMember");

        if (Objects.nonNull(memberUser)) {
            MemberProfile memberProfile = profileService.getMemberProfileByUserNo(memberUser.getUserNo());
            model.addAttribute("locationNo", memberProfile.getLocationNo());
        }

        return "list";
    }


}
