package com.tu.goodsbuy.service;

import com.tu.goodsbuy.dto.MemberUser;

public class SocialLoginService implements LoginService {
    @Override
    public void checkMemberUser(MemberUser memberUser) {

    }

    @Override
    public boolean validateLogin(String id, String pwd) {
        return false;
    }

    @Override
    public boolean isLoginState() {
        return false;
    }
}
