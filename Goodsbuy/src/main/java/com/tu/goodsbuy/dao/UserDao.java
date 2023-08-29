package com.tu.goodsbuy.dao;

import com.tu.goodsbuy.dto.MemberUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

public interface UserDao {

    @Select("SELECT * FROM WHERE user_id = #{user_id} AND user_pwd = #{user_pwd}")
    Optional<MemberUser> getMemberUserByIdAndPwd(@Param("user_id") String userId, @Param("user_pwd") String userPwd);

    @Select("SELECT COUNT(*) > 0 WHERE user_id = #{user_id}")
    int isExistMemberById(@Param("user_id") String userId);

    @Insert("INSERT INTO member_user(user_id,user_pwd) values(#{user_id} ,#{user_pwd})")
    int createAccount(@Param("user_id") String userId, @Param("user_pwd") String userPwd);


}
