package com.tu.goodsbuy.dao;

import com.tu.goodsbuy.dto.MemberUser;

public interface LoginDao {

    boolean isLoginState();

    void checkMemberUser(MemberUser memberUser);

    boolean validateLogin(String id, String pwd);

}
