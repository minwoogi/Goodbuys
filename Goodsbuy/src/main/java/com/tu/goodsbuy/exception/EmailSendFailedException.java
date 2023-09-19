package com.tu.goodsbuy.exception;

public class EmailSendFailedException extends RuntimeException{
    public EmailSendFailedException() {
        super("이메일 전송에 실패하였습니다.");
    }
}
