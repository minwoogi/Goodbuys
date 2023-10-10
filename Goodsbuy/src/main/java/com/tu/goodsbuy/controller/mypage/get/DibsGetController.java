package com.tu.goodsbuy.controller.mypage.get;

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
public class DibsGetController {


    private final ProductService productService;


    @GetMapping("/dibs")
    public String getDibsList(Model model, HttpServletRequest request) {

        List<Product> dibsProudctList = productService.getDibsProductListByUserNo(
                ((MemberUser) request.getSession(false).getAttribute("loginMember")).getUserNo());

        model.addAttribute("dibsProductList", dibsProudctList);



        return "/profile/dibs";
    }

}