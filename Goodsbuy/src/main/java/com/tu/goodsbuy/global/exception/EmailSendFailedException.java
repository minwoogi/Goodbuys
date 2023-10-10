package com.tu.goodsbuy.global.exception;

public class EmailSendFailedException extends RuntimeException{
    public EmailSendFailedException() {
        super("이메일 확인에 실패하였습니다.");
    }
}
