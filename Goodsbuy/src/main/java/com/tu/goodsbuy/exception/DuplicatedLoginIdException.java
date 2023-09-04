package com.tu.goodsbuy.exception;

public class DuplicatedLoginIdException extends RuntimeException {

    public DuplicatedLoginIdException() {
        super("Duplicate login id");
    } // 중복된 아이디

    public DuplicatedLoginIdException(String message) {
        super(message);
    }
}
