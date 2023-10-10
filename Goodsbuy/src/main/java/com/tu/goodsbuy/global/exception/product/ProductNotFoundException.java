package com.tu.goodsbuy.global.exception.product;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
        super("ProductNotFoundException By productNo");
    }
}
