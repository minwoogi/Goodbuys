package com.tu.goodsbuy.controller.product;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductInfoController {


    @GetMapping("/product")
    public String getProductInfoPage() {
        return "product/productInfo";
    }


}
