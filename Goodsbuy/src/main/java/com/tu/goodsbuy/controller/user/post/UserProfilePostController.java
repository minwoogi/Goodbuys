package com.tu.goodsbuy.controller.user.post;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserProfilePostController {


    @PostMapping("/profile/nickname")
    public String updateNickname() {
        return "redirect:/profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile() {

        return "profile";
    }

}
