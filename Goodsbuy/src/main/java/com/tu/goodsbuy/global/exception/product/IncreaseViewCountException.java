package com.tu.goodsbuy.global.exception;

public class IncreaseViewCountException extends RuntimeException{
    public IncreaseViewCountException() {
        super("조회수 증가에 실패하였습니다.");
    }
}
