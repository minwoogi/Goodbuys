package com.tu.goodsbuy.service;


import com.tu.goodsbuy.config.MybatisManager;
import com.tu.goodsbuy.repo.UserRepository;
import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.exception.AuthenticationDataMissingException;

import java.util.Objects;
import java.util.Optional;

public class UserService {

    private static UserService INSTANCE;
    private final UserRepository userRepository;

    public static UserService getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UserService();
        }
        return INSTANCE;
    }

    public UserService() {
        this.userRepository = MybatisManager.getMapper(UserRepository.class);
    }

    public Long doLogin(String userId, String userPwd) {

        Long userNo = userRepository.getUserNoByIdAndPwd(userId, userPwd);
        return Objects.isNull(userNo) ? -1L : userNo;
    }


}

