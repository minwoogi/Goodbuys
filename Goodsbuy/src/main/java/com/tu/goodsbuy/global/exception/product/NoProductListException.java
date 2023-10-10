package com.tu.goodsbuy.global.exception.product;

public class NoProductListException extends RuntimeException {

    public NoProductListException() {
        super("등록된 상품이 없습니다.");
    }
}
