package com.tu.goodsbuy.service;

import com.tu.goodsbuy.dto.MemberUser;

public interface LoginService {

    void checkMemberUser(MemberUser memberUser);

    boolean validateLogin(String id, String pwd);

    boolean isLoginState();


}
