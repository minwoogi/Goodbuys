package com.tu.goodsbuy.exception;

public class MakeMemberProfileException extends RuntimeException {
    public MakeMemberProfileException() {
        super("member profile error");
    }

    public MakeMemberProfileException(String message) {
        super(message);
    }
}
