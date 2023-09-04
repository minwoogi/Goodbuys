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

    @Insert("INSERT INTO member_user(user_id,user_pwd) values(#{user_id} ,#{user_pwd})")
    void makeMember();


}
