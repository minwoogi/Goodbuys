package com.tu.goodsbuy.service;


import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.exception.DuplicatedLoginIdException;
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


}

