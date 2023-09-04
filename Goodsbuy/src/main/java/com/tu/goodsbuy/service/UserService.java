package com.tu.goodsbuy.service;


import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public MemberUser doLogin(String userId, String userPwd) {
        // TODO advice 적용 전
        MemberUser memberUser;

        if (userRepository.getMemberUserByIdAndPwd(userId, userPwd).isPresent()) {
            memberUser = userRepository.getMemberUserByIdAndPwd(userId, userPwd).get();
        } else {
            return null;
        }
        return memberUser;
    }


}

