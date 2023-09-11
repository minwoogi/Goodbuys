package com.tu.goodsbuy.exception;

public class NoProductListException extends RuntimeException {

    public NoProductListException() {
        super("등록된 상품이 없습니다.");
    }
}
