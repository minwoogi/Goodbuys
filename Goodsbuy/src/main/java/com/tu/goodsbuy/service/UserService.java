package com.tu.goodsbuy.service;


import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.exception.DuplicatedLoginIdException;
import com.tu.goodsbuy.exception.MakeMemberException;
import com.tu.goodsbuy.exception.MakeMemberProfileException;
import com.tu.goodsbuy.repo.UserRepository;
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



        return userRepository.validMember(userId) == 1 ? false : true;
    }

    public void makeMemberUser(String userId, String userPwd) {
        if (userRepository.makeMemberUser(userId, userPwd) == 0) {
            new MakeMemberException();
        }
    }

    public void makeMemberProfile(String userId, String nickname) {

        if (userRepository.makeMemberProfile(userRepository.findUserNoById(userId), nickname) == 0) {
            new MakeMemberProfileException();
        }


    }


}

