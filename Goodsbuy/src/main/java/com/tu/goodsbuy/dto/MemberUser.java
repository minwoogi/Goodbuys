package com.tu.goodsbuy.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class MemberUser {
    
    private Long userNo;
    private String userId;
    private String userPwd;

    public MemberUser(Long userNo, String userId, String userPwd) {
        this.userNo = userNo;
        this.userId = userId;
        this.userPwd = userPwd;
    }

    public Long getUserNo() {
        return userNo;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

}
