package com.tu.goodsbuy.global.exception.profile;

public class MakeMemberProfileException extends RuntimeException {
    public MakeMemberProfileException() {
        super("member profile error");
    }

    public MakeMemberProfileException(String message) {
        super(message);
    }
}
