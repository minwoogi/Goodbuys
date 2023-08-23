package com.tu.goodsbuy.exception;

public class DuplicatedLoginIdException extends RuntimeException{

    public DuplicatedLoginIdException() {
        System.out.println("Duplicate login id");
    }

    public DuplicatedLoginIdException(String message) {
        super(message);
    }
}
