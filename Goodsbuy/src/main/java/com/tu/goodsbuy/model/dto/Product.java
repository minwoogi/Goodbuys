package com.tu.goodsbuy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {

    private Long productNo;
    private String userId;
    private String productName;
    private String productImageUrl;
    private String productPrice;
    private String location;
    private short categoryNo;
}
