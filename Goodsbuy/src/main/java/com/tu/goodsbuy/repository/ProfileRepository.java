package com.tu.goodsbuy.repository;


import com.tu.goodsbuy.dto.MemberProfile;
import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface ProfileRepository {


    @Update("UPDATE member_profile SET " +
            "update_date= now(), introduction=#{introduction} , image_url=#{url} , birthday= #{birthday}, location_no=#{location_no}" +
            " WHERE user_no = #{user_no}")
    int updateMemberProfile(@Param("user_no") Long userNo, @Param("introduction") String introduction,
                            @Param("url") String imageUrl, @Param("birthday") String birthday, @Param("location_no") String locationNo);


    @Update("UPDATE member_profile SET " +
            "nickname=#{nickname} , update_date=now()" +
            " WEHRE user_no = #{user_no}")
    int updateNickname(@Param("user_no") Long userNo, @Param("nickname") String nickname);

    @Select("SELECT *" +
            "FROM member_profile " +
            "WHERE user_no=#{user_no}")
    Optional<MemberProfile> getMemberProfileByUserNo(@Param("user_no") Long userNo);

    @Insert("INSERT INTO " +
            "member_profile(user_no,nickname,join_date,update_date) " +
            "values(#{user_no} ,#{nickname} , now(), now())")
    int makeMemberProfile(@Param("user_no") Long userNo, @Param("nickname") String nickname);
}
