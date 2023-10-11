package com.tu.goodsbuy.repository.param;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductBuilder {

    private Long userNo;
    private String nickname;
    private String productName;
    private String productImageUrl;
    private String productPrice;
    private String location;
    private String categoryNo;
    private String info;
}
