package com.tu.goodsbuy.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class MemberUser {

    private Long userNo;
    private String userId;
    private String userPwd;


}
