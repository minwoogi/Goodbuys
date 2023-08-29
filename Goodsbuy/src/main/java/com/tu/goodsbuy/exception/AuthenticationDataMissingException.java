package com.tu.goodsbuy.exception;

public class AuthenticationDataMissingException  extends RuntimeException{

    public AuthenticationDataMissingException() {
        super("id or password null");
    }

    public AuthenticationDataMissingException(String message) {
        super(message);
    }
}
