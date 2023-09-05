package com.tu.goodsbuy.repo;

import com.tu.goodsbuy.dto.MemberUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;


@Mapper
public interface UserRepository {

    @Select("SELECT user_no FROM member_user WHERE user_id = #{user_id} AND user_pwd = #{user_pwd}")
    Optional<MemberUser> getMemberUserByIdAndPwd(@Param("user_id") String userId, @Param("user_pwd") String userPwd);


    @Select("SELECT COUNT(*) > 0 FROM member_user WHERE user_id = #{user_id} ")
    int validMember(@Param("user_id") String userId);

    @Insert("INSERT INTO member_user(user_id,user_pwd) values(#{user_id} ,#{user_pwd})")
    int makeMemberUser(@Param("user_id") String userId, @Param("user_pwd") String userPwd);

    @Insert("INSERT INTO member_profile(user_no,nickname,join_date,update_date) values(#{user_no} ,#{nickname} , now(), now())")
    int makeMemberProfile(@Param("user_no") Long userNo, @Param("nickname") String nickname);

    @Select("SELECT user_no FROM member_user WHERE user_id= #{user_id} ")
    Long findUserNoById(@Param("user_id") String userId);


}
