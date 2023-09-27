package com.tu.goodsbuy.controller.mypage.get;


import com.tu.goodsbuy.model.dto.Product;
import com.tu.goodsbuy.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HistoryGetController {

    private final ListService listService;

    @GetMapping("/sales-history")
    public String getSalesHistoryPage(Model model) {


//        List<Product> salesProductList = listService.getProductListByLocation(memberProfile.getLocation());
//        model.addAttribute("salesProductList", salesProductList);


        return "/profile/salesHistory";
    }
}
