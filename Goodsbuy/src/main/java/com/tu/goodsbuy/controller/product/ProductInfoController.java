package com.tu.goodsbuy.controller.product;


import com.tu.goodsbuy.controller.param.ProductCreateParam;
import com.tu.goodsbuy.controller.param.ProductUpdateParam;
import com.tu.goodsbuy.global.util.ScriptWriterUtil;
import com.tu.goodsbuy.model.dto.MemberProfile;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.model.dto.Product;
import com.tu.goodsbuy.service.ProductService;
import com.tu.goodsbuy.service.ProfileService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductInfoController {


    private final ProductService productService;
    private final ProfileService profileService;

    @Value("${productImage.upload.path}")
    private String productImagePath;


    @GetMapping("/product/{productNo}")
    public String getProductInfoPage(@SessionAttribute(value = "loginMember", required = false) MemberUser memberUser,
                                     @PathVariable("productNo") String productNo, Model model) {


        productService.increaseViewByProductNo(Long.valueOf(productNo));


        model.addAttribute("product",
                productService.getProductByProductNo(Long.valueOf(productNo)));
        model.addAttribute("dibsCount",
                productService.getDibsCountProductByProductNo(Long.valueOf(productNo)));

        model.addAttribute("dibsState", productService.isDibs(memberUser.getUserNo(), productNo));

        MemberProfile memberProfile = profileService.getMemberProfileByUserNo(memberUser.getUserNo());
        List<Product> productList = productService.getProductListByLocation(memberProfile.getLocation());
        model.addAttribute("productList", productList);


        return "product/productInfo";
    }

    @PostMapping("/product/delete.do")
    public String deleteProduct(@RequestParam String productNo) {
        productService.deleteProductByProductNo(productNo);
        return "redirect:/goodsbuy/list";
    }

    @PostMapping("/product/soldOut.do") // 판매완료등록
    public String soldOutProduct(@RequestParam String productNo) {
        productService.registerSoldOut(productNo);
        return "redirect:/product/" + productNo;
    }

    @GetMapping("/product/update")
    public String getProductUpdatePage(@SessionAttribute(value = "loginMember", required = false) MemberUser memberUser,
                                       @RequestParam String productNo, Model model) {

        model.addAttribute("product",
                productService.getProductByProductNo(Long.valueOf(productNo)));
        model.addAttribute("dibsCount",
                productService.getDibsCountProductByProductNo(Long.valueOf(productNo)));

        MemberProfile memberProfile = profileService.getMemberProfileByUserNo(memberUser.getUserNo());
        List<Product> productList = productService.getProductListByLocation(memberProfile.getLocation());
        model.addAttribute("productList", productList);


        return "product/productUpdate";
    }

    @PostMapping("/product/update.do")
    public String updateProduct(@Valid ProductUpdateParam productUpdateParam, BindingResult br,
                                @RequestParam(required = false) MultipartFile file, Model model) {

        if (br.hasErrors()) {
            return "redirect:/errorPage";
        }

        if (Objects.nonNull(file)) {
            profileService.deleteImage(productImagePath, productService.getProductImageUrlByProductNo(productUpdateParam.getProductNo()));
            String fileName = profileService.uploadSaveImageAndGetIdentifier(productImagePath, file);
            productService.updateProductImgUrlByProductNo(fileName, productUpdateParam.getProductNo());
        }

        productService.updateProductInfoByProductUpdateParam(productUpdateParam);


        return "product/productUpdate";
    }


    @PostMapping("/product/dibs")
    public String doDibsProduct(@SessionAttribute(value = "loginMember", required = false) MemberUser memberUser,
                                @RequestParam String productNoDibsState) {

        String[] arr = productNoDibsState.split("/");

        String productNo = arr[0];
        String productDibsState = arr[1];

        if (productDibsState.equals("0")) { // 관심상품 등록
            productService.registerDibsProduct(memberUser.getUserNo(), productNo);
        }

        if (productDibsState.equals("1")) { // 관심상품 해제
            productService.deleteDibsProduct(memberUser.getUserNo(), productNo);
        }

        return "redirect:/product/" + productNo;
    }

    @GetMapping("/product/create")
    public String getCreateProductPage(@SessionAttribute(value = "loginMember") MemberUser loginMember
            , HttpServletResponse response, Model model) throws IOException {
        MemberProfile memberProfile = profileService.getMemberProfileByUserNo(loginMember.getUserNo());

        if (memberProfile.getEmailCheck() == 0) {
            ScriptWriterUtil.writeAndRedirect(response, "이메일 인증을 진행해주세요.", "/profile/email");
        }

        if (Objects.isNull(memberProfile.getLocation())) {
            ScriptWriterUtil.writeAndRedirect(response, "마이페이지에서 지역을 설정 해주세요", "/profile/location");
        }

        model.addAttribute("profile", memberProfile);

        return "product/productCreate";
    }

    @PostMapping("/product/create.do")
    public String createProduct(@Valid ProductCreateParam productCreateParam, BindingResult br,
                                @SessionAttribute(value = "loginMember") MemberUser loginMember,
                                @RequestParam(required = false) MultipartFile file,
                                HttpServletResponse response) throws IOException {

        if (br.hasErrors()) {
            ScriptWriterUtil.writeAndRedirect(response,
                    Objects.requireNonNull(br.getFieldError("productPrice")).getDefaultMessage(), "/product/create");
        }

        MemberProfile memberProfile = profileService.getMemberProfileByUserNo(loginMember.getUserNo());

        String fileName = null;

        if (Objects.nonNull(file)) {
            fileName = profileService.uploadSaveImageAndGetIdentifier(productImagePath, file);
        }

        productService.createProduct(loginMember.getUserNo(), memberProfile.getNickName(), fileName, memberProfile, productCreateParam);

        return "redirect:/goodsbuy/list";
    }


}
