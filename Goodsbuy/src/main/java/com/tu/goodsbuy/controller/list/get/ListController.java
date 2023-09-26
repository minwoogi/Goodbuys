package com.tu.goodsbuy.controller.list.get;

import com.tu.goodsbuy.model.dto.MemberProfile;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.model.dto.Product;
import com.tu.goodsbuy.service.ListService;
import com.tu.goodsbuy.service.ProfileService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/goodsbuy")
@SessionAttributes({"location"})
public class ListController {

    private final ProfileService profileService;
    private final ListService listService;

    @GetMapping(value = {" ", "/", "/list"})
    public String getList(@SessionAttribute(value = "loginMember", required = false) MemberUser memberUser, Model model) {

        if (Objects.nonNull(memberUser)) {
            MemberProfile memberProfile = profileService.getMemberProfileByUserNo(memberUser.getUserNo());
            model.addAttribute("location", memberProfile.getLocation());
            model.addAttribute("emailCheck",memberProfile.getEmailCheck());

            List<Product> productList = listService.getProductListByLocation(memberProfile.getLocation());
            model.addAttribute("productList", productList);
        }

        return "product/list";
    }

    @GetMapping("/list/search")
    public String getSearchList(@RequestParam(required = false, defaultValue = "") String productName,
                                HttpServletRequest request, Model model) {

        request.setAttribute("searchProductName", productName);

        List<Product> productList = listService.getSearchProductListByProductNameAndLocation(
                (String) request.getSession().getAttribute("location"), productName);
        model.addAttribute("productList", productList);

        return "product/list";
    }
}
