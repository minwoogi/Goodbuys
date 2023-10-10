package com.tu.goodsbuy.controller.product;

import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.model.dto.Product;
import com.tu.goodsbuy.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyProductGetController {

    private final ProductService productService;

    @GetMapping("/sales-items")
    public String getSalesItemsPage(Model model, HttpServletRequest request) {


        List<Product> salesProductList = productService.getSalesItemsProductListByUserNo(
                ((MemberUser) request.getSession(false).getAttribute("loginMember")).getUserNo());
        model.addAttribute("salesProductList", salesProductList);
        model.addAttribute("divState", "판매중인 상품");
        model.addAttribute("state", "판매중");


        return "/profile/myProduct";
    }


    @GetMapping("/sales-history")
    public String getSalesHistoryPage(Model model, HttpServletRequest request) {

        List<Product> salesProductList = productService.getSalesHistoryProductListByUserNo(
                ((MemberUser) request.getSession(false).getAttribute("loginMember")).getUserNo());
        model.addAttribute("salesProductList", salesProductList);
        model.addAttribute("divState", "판매 완료 상품");
        model.addAttribute("state", "거래 완료");

        return "/profile/myProduct";

    }


    @GetMapping("/purchase-history")
    public String getPurchaseHistoryPage(Model model, HttpServletRequest request) {

        List<Product> salesProductList = productService.getSalesHistoryProductListByUserNo(
                ((MemberUser) request.getSession(false).getAttribute("loginMember")).getUserNo());
        model.addAttribute("purchaseProductList", salesProductList);
        model.addAttribute("divState", "구매한 상품");
        model.addAttribute("state", "거래 완료");

        return "/profile/myProduct";

    }
}
