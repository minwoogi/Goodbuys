package com.tu.goodsbuy.global.exception.profile;

public class GetProfileException extends RuntimeException {
    public GetProfileException() {
        super("프로필 조회에 실패하였습니다.");
    }


}
