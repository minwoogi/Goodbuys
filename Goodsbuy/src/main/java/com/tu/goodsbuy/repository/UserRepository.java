package com.tu.goodsbuy.repository;

import com.tu.goodsbuy.dto.MemberProfile;
import com.tu.goodsbuy.dto.MemberUser;
import org.apache.ibatis.annotations.*;

import java.util.Optional;


@Mapper
public interface UserRepository {
    @Select("SELECT user_no " +
            "FROM member_user " +
            "WHERE user_id = #{user_id} AND user_pwd = #{user_pwd}")
    Optional<MemberUser> getMemberUserByIdAndPwd(@Param("user_id") String userId, @Param("user_pwd") String userPwd);

    @Select("SELECT COUNT(*) > 0 " +
            "FROM member_user " +
            "WHERE user_id = #{user_id} ")
    int validMember(@Param("user_id") String userId);

    @Insert("INSERT INTO " +
            "member_user(user_id,user_pwd) " +
            "values(#{user_id} ,#{user_pwd})")
    int makeMemberUser(@Param("user_id") String userId, @Param("user_pwd") String userPwd);


    @Select("SELECT user_no " +
            "FROM member_user " +
            "WHERE user_id= #{user_id} ")
    Long findUserNoById(@Param("user_id") String userId);


}
