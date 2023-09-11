package com.tu.goodsbuy.service;


import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.exception.*;
import com.tu.goodsbuy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public MemberUser doLogin(String userId, String userPwd) {
        return userRepository.getMemberUserByIdAndPwd(userId, userPwd).orElseThrow(DuplicatedLoginIdException::new);
    }

    public boolean isValidRegister(String userId) {
        return userRepository.validMember(userId) != 1;
    }

    public void makeMemberUser(String userId, String userPwd) {
        if (userRepository.makeMemberUser(userId, userPwd) == 0) {
            throw new MakeMemberException();
        }
    }

}

