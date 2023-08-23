package com.tu.goodsbuy.dto;

public class MemberUser {

    public MemberUser(int userIo, String userId, String userPwd) {
        this.userIo = userIo;
        this.userId = userId;
        this.userPwd = userPwd;
    }

    private int userIo;
    private String userId;
    private String userPwd;

    public int getUserIo() {
        return userIo;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPwd() {
        return userPwd;
    }


}
