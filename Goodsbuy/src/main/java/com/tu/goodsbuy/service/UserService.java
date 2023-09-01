package com.tu.goodsbuy.service;


import com.tu.goodsbuy.config.MybatisManager;
import com.tu.goodsbuy.dao.UserDao;
import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.exception.AuthenticationDataMissingException;

public class UserService {

    private static UserService INSTANCE;
    private final UserDao userDao;

    public static UserService getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UserService();
        }
        return INSTANCE;
    }

    public UserService() {
        this.userDao = MybatisManager.getMapper(UserDao.class);
    }

    public MemberUser getMemberUserByIdAndPwd(String userId, String userPwd) {

        if (userId.equals("") || userPwd.equals("")) {
            throw new AuthenticationDataMissingException();
        }

        MemberUser memberUser = userDao.getMemberUserByIdAndPwd(userId, userPwd).orElseGet(null);
        return memberUser;
    }


}

