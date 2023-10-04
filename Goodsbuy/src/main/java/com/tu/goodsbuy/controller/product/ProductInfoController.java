package com.tu.goodsbuy.controller.product;


import com.tu.goodsbuy.model.dto.MemberProfile;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.model.dto.Product;
import com.tu.goodsbuy.service.ListService;
import com.tu.goodsbuy.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductInfoController {


    private final ListService listService;
    private final ProfileService profileService;


    @GetMapping("/product/{productNo}")
    public String getProductInfoPage(@SessionAttribute(value = "loginMember", required = false) MemberUser memberUser,
                                     @PathVariable("productNo") String productNo, Model model) {


        listService.increaseViewByProductNo(Long.valueOf(productNo));


        model.addAttribute("product",
                listService.getProductByProductNo(Long.valueOf(productNo)));
        model.addAttribute("dibsCount",
                listService.getDibsCountProductByProductNo(Long.valueOf(productNo)));

        MemberProfile memberProfile = profileService.getMemberProfileByUserNo(memberUser.getUserNo());
        List<Product> productList = listService.getProductListByLocation(memberProfile.getLocation());
        model.addAttribute("productList", productList);


        return "product/productInfo";
    }

    @PostMapping("/product/delete.do")
    public String deleteProduct(@RequestParam String productNo) {
        listService.deleteProductByProductNo(productNo);
        return "redirect:/goodsbuy/list";
    }

    @PostMapping("/product/update.do")
    public String test(@SessionAttribute(value = "loginMember", required = false) MemberUser memberUser,
                       @RequestParam String productNo , Model model){

        model.addAttribute("product",
                listService.getProductByProductNo(Long.valueOf(productNo)));
        model.addAttribute("dibsCount",
                listService.getDibsCountProductByProductNo(Long.valueOf(productNo)));

        MemberProfile memberProfile = profileService.getMemberProfileByUserNo(memberUser.getUserNo());
        List<Product> productList = listService.getProductListByLocation(memberProfile.getLocation());
        model.addAttribute("productList", productList);


        return "product/productUpdate";
    }



}
