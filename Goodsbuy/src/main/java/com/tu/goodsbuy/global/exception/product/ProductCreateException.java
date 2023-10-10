package com.tu.goodsbuy.global.exception.product;

public class ProductCreateException extends RuntimeException{

    public ProductCreateException() {
        super("상품 등록 실패");
    }
}
