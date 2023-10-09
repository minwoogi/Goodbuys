package com.tu.goodsbuy.controller.product;


import com.tu.goodsbuy.controller.param.ProductUpdateParam;
import com.tu.goodsbuy.model.dto.MemberProfile;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.model.dto.Product;
import com.tu.goodsbuy.service.ListService;
import com.tu.goodsbuy.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductInfoController {


    private final ListService listService;
    private final ProfileService profileService;

    @Value("${productImage.upload.path}")
    private String productImagePath;


    @GetMapping("/product/{productNo}")
    public String getProductInfoPage(@SessionAttribute(value = "loginMember", required = false) MemberUser memberUser,
                                     @PathVariable("productNo") String productNo, Model model) {


        listService.increaseViewByProductNo(Long.valueOf(productNo));


        model.addAttribute("product",
                listService.getProductByProductNo(Long.valueOf(productNo)));
        model.addAttribute("dibsCount",
                listService.getDibsCountProductByProductNo(Long.valueOf(productNo)));

        model.addAttribute("dibsState",listService.isDibs(memberUser.getUserNo(), productNo));

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

    @PostMapping("/product/soldOut.do") // 판매완료등록
    public String soldOutProduct(@RequestParam String productNo) {
        listService.deleteProductByProductNo(productNo);
        return "redirect:/goodsbuy/list";
    }

    @GetMapping("/product/update")
    public String getProductUpdatePage(@SessionAttribute(value = "loginMember", required = false) MemberUser memberUser,
                                       @RequestParam String productNo, Model model) {

        model.addAttribute("product",
                listService.getProductByProductNo(Long.valueOf(productNo)));
        model.addAttribute("dibsCount",
                listService.getDibsCountProductByProductNo(Long.valueOf(productNo)));

        MemberProfile memberProfile = profileService.getMemberProfileByUserNo(memberUser.getUserNo());
        List<Product> productList = listService.getProductListByLocation(memberProfile.getLocation());
        model.addAttribute("productList", productList);


        return "product/productUpdate";
    }

    @PostMapping("/product/update.do")
    public String updateProduct(@Valid ProductUpdateParam productUpdateParam, BindingResult br,
                                @RequestParam(required = false) MultipartFile file, Model model) {

        if (br.hasErrors()) {
            return "redirect:/errorPage";
        }

        if (!file.isEmpty()) {
            profileService.deleteImage(productImagePath, listService.getProductImageUrlByProductNo(productUpdateParam.getProductNo()));
            String fileName = profileService.uploadSaveImageAndGetIdentifier(productImagePath, file);
            listService.updateProductImgUrlByProductNo(fileName, productUpdateParam.getProductNo());
        }

        listService.updateProductInfoByProductUpdateParam(productUpdateParam);


        return "product/productUpdate";
    }


    @PostMapping("/product/dibs")
    public String doDibsProduct(@SessionAttribute(value = "loginMember", required = false) MemberUser memberUser,
                                @RequestParam String productNoDibsState) {

        String[] arr = productNoDibsState.split("/");

        String productNo = arr[0];
        String productDibsState = arr[1];

        if (productDibsState.equals("0")) { // 관심상품 등록
            listService.registerDibsProduct(memberUser.getUserNo(), productNo);
        }

        if (productDibsState.equals("1")) { // 관심상품 해제
            listService.deleteDibsProduct(memberUser.getUserNo(), productNo);
        }

        return "redirect:/product/" + productNo;
    }


}
