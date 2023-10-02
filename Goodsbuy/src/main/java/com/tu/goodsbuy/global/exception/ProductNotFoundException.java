package com.tu.goodsbuy.global.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
        super("ProductNotFoundException By productNo");
    }
}
