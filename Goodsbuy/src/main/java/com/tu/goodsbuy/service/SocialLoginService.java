package com.tu.goodsbuy.service;

import com.tu.goodsbuy.dto.MemberUser;

public class SocialLoginService implements LoginService {

    @Override
    public MemberUser getMemberUserByIdAndPwd(String userId, String userPwd) {
        return null;
    }

    @Override
    public int isExistMemberById(String userId) {
        return 0;
    }

    @Override
    public int createAccount(String userId, String userPwd) {
        return 0;
    }
}
