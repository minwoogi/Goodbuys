package com.tu.goodsbuy.global.exception.product;

public class ProductUpdateException extends RuntimeException{
    public ProductUpdateException() {
        super("상품 정보 업데이트 실패");
    }
}
