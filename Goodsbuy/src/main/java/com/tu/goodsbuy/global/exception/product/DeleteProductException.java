package com.tu.goodsbuy.global.exception.product;

public class DeleteProductException extends RuntimeException{
    public DeleteProductException() {
        super("상품 삭제에 실패하였습니다.");
    }
}
