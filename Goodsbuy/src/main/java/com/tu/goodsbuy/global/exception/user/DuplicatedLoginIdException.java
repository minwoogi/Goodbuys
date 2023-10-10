package com.tu.goodsbuy.global.exception.user;

public class DuplicatedLoginIdException extends RuntimeException {

    public DuplicatedLoginIdException() {
        super("계정 혹은 비밀번호가 일치하지 않습니다. 입력한 내용을 다시 확인해 주세요.");
    } // 이미 사용중인 아이디

    public DuplicatedLoginIdException(String message) {
        super(message);
    }
}
