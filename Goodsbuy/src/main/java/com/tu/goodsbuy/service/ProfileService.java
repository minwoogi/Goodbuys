package com.tu.goodsbuy.service;


import com.tu.goodsbuy.model.dto.MemberProfile;
import com.tu.goodsbuy.exception.GetProfileException;
import com.tu.goodsbuy.exception.MakeMemberProfileException;
import com.tu.goodsbuy.exception.NicknameDuplicateException;
import com.tu.goodsbuy.repository.ProfileRepository;
import com.tu.goodsbuy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;


    public void makeMemberProfile(String userId, String nickname) {
        if (profileRepository.makeMemberProfile(userRepository.findUserNoById(userId), nickname) == 0) {
            throw new MakeMemberProfileException();
        }
    }

    public MemberProfile getMemberProfileByUserNo(Long userNo) {
        return profileRepository.getMemberProfileByUserNo(userNo).orElseThrow(GetProfileException::new);
    }

    public void updateNickname(Long userNo, String nickname) {
        if (profileRepository.updateNickname(userNo, nickname) == 0) {
            throw new NicknameDuplicateException();
        }
    }

    public void updateProfile(Long userNo) {

    }
}
