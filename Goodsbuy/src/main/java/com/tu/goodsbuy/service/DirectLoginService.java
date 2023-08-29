package com.tu.goodsbuy.service;


import com.tu.goodsbuy.config.MybatisManager;
import com.tu.goodsbuy.dao.UserDao;
import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.exception.AuthenticationDataMissingException;

import java.lang.reflect.Member;
import java.util.Optional;

public class DirectLoginService implements LoginService {

    private static LoginService INSTANCE;
    private final UserDao userDao;

    public static LoginService getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new DirectLoginService();
        }
        return INSTANCE;
    }

    public DirectLoginService() {
        this.userDao = MybatisManager.getMapper(UserDao.class);
    }


    @Override
    public MemberUser getMemberUserByIdAndPwd(String userId, String userPwd) {

        if (userId.equals("") || userPwd.equals("")) {
            throw new AuthenticationDataMissingException();
        }

        MemberUser memberUser = userDao.getMemberUserByIdAndPwd(userId, userPwd).orElseGet(null);
        return memberUser;
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
