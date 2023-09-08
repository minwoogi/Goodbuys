package com.tu.goodsbuy.exception;

public class NicknameDuplicateException extends  RuntimeException{

    public NicknameDuplicateException() {
        super("닉네임 중복");
    }

    public NicknameDuplicateException(String message) {
        super(message);
    }
}
