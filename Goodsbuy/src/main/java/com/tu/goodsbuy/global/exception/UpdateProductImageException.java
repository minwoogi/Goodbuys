package com.tu.goodsbuy.global.exception;

public class UpdateProductImageException extends RuntimeException{
    public UpdateProductImageException() {
        super("상품 이미지 URL 업데이트 실패");
    }
}
