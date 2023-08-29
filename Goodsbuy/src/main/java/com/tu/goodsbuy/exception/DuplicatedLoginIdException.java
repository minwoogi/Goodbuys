package com.tu.goodsbuy.exception;

public class DuplicatedLoginIdException extends RuntimeException {

    public DuplicatedLoginIdException() {
        super("Duplicate login id");
    }

    public DuplicatedLoginIdException(String message) {
        super(message);
    }
}
