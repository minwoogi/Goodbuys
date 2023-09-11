package com.tu.goodsbuy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {

    private Long productNo;
    private Long userNo;
    private String nickname;
    private String productName;
    private String productImageUrl;
    private String productPrice;
    private String location;
    private short categoryNo;


    @Override
    public String toString() {
        return "Product{" +
                "productNo=" + productNo +
                ", userNo=" + userNo +
                ", nickname='" + nickname + '\'' +
                ", productName='" + productName + '\'' +
                ", productImageUrl='" + productImageUrl + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", location='" + location + '\'' +
                ", categoryNo=" + categoryNo +
                '}';
    }
}
