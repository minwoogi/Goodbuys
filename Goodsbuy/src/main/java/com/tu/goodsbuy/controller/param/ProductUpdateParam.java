package com.tu.goodsbuy.controller.param;


import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class ProductUpdateParam {

    private String productNo;
    private String productName;

    @Pattern(regexp = "^[0-9]+$", message = "숫자만 입력가능합니다.")
    private String productPrice;

    private String productInfo;
}
