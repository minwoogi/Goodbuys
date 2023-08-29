package com.tu.goodsbuy.service;

import com.tu.goodsbuy.dto.MemberUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoginService {


    MemberUser getMemberUserByIdAndPwd( String userId, String userPwd);


    int isExistMemberById(String userId);


    int createAccount(String userId,  String userPwd);



}
