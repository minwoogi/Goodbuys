package com.tu.goodsbuy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Product {

    private Long productNo;
    private Long userNo;
    private String nickname;
    private String productName;
    private String productImageUrl;
    private String productPrice;
    private String location;
    private short categoryNo;

}
