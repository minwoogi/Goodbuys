package com.tu.goodsbuy.service;


import com.tu.goodsbuy.global.exception.DuplicatedLoginIdException;
import com.tu.goodsbuy.global.exception.MakeMemberException;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    @Transactional(readOnly = true)
    public MemberUser doLogin(String userId, String userPwd) {
        return userRepository.getMemberUserByIdAndPwd(userId, userPwd).orElseThrow(DuplicatedLoginIdException::new);
    }


    @Transactional(readOnly = true)
    public boolean isValidRegister(String userId, String nickname) {
        if (userRepository.isUserIdExists(userId) != 1 && userRepository.isNicknameExists(nickname) != 1) {
            return true;
        }
        return false;
    }


    @Transactional
    public void makeMemberUser(String userId, String userPwd) {
        if (userRepository.makeMemberUser(userId, userPwd) == 0) {
            throw new MakeMemberException();
        }
    }

    @Transactional(readOnly = true)
    public boolean isUserIdExists(String id) {
        return userRepository.isUserIdExists(id) == 1;
    }

    @Transactional(readOnly = true)
    public boolean isNicknameExists(String nickname) {
        return userRepository.isNicknameExists(nickname) == 1;
    }


}

