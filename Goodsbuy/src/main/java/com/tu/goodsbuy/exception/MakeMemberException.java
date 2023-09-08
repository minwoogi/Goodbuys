package com.tu.goodsbuy.exception;

public class MakeMemberException extends RuntimeException {

    public MakeMemberException() {
        super("Register member_user 등록 실패");
    }

    public MakeMemberException(String message) {
        super(message);
    }
}
