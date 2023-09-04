package com.tu.goodsbuy.exception;

public class DuplicatedLoginIdException extends RuntimeException {

    public DuplicatedLoginIdException() {
        super("Duplicate login id");
    } // 이미 사용중인 아이디

    public DuplicatedLoginIdException(String message) {
        super(message);
    }
}
