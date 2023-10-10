package com.tu.goodsbuy.controller.param;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateParam {

    @NotNull(message = "상품명을 입력하세요.")
    @NotBlank(message = "상품명을 입력하세요.")
    private String productName;

    @NotNull(message = "가격을 입력하세요.")
    @Pattern(regexp = "^[0-9]+$", message = "숫자만 입력가능합니다.")
    private String productPrice;

    @NotNull(message = "상품 정보를 입력하세요.")
    @NotBlank(message = "상품 정보를 입력하세요.")
    private String productInfo;

    @NotNull(message = "카테고리를 선택하세요.")
    private String categoryNo;

}