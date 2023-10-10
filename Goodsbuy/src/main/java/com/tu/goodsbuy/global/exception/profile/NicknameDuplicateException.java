package com.tu.goodsbuy.global.exception;

public class NicknameDuplicateException extends  RuntimeException{

    public NicknameDuplicateException() {
        super("이미 사용중인 닉네임 입니다.");
    }

    public NicknameDuplicateException(String message) {
        super(message);
    }
}
