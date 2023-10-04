package com.tu.goodsbuy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@AllArgsConstructor
@ToString
public class Product {

    private Long productNo;
    private Long userNo;
    private String nickname;
    private String productName;
    private String productPrice;
    private String location;
    private short categoryNo;
    private Long view;
    private Date makeTime;
    private String productInfo;

}
