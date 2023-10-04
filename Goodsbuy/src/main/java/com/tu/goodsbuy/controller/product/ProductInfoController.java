package com.tu.goodsbuy.controller.product;


import com.tu.goodsbuy.service.ListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductInfoController {


    private final ListService listService;


    @GetMapping("/product/{productNo}")
    public String getProductInfoPage(@PathVariable("productNo") String productNo, Model model) {


        log.info("productNo --> " + productNo);
        listService.increaseViewByProductNo(Long.valueOf(productNo));


        model.addAttribute("product",
                listService.getProductByProductNo(Long.valueOf(productNo)));
        model.addAttribute("dibsCount",
                listService.getDibsCountProductByProductNo(Long.valueOf(productNo)));

        return "product/productInfo";
    }

    @PostMapping("/product/delete.do")
    public String deleteProduct(@RequestParam String productNo) {
        listService.deleteProductByProductNo(productNo);
        return "redirect:/goodsbuy/list";
    }


}
