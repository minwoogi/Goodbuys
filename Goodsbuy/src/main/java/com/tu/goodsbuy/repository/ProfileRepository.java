package com.tu.goodsbuy.repository;


import com.tu.goodsbuy.model.dto.MemberProfile;
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
            " WHERE user_no = #{user_no}")
    int updateNickname(@Param("user_no") Long userNo, @Param("nickname") String nickname);

    @Select("SELECT *" +
            "FROM member_profile " +
            "WHERE user_no=#{user_no}")
    Optional<MemberProfile> getMemberProfileByUserNo(@Param("user_no") Long userNo);

    @Insert("INSERT INTO " +
            "member_profile(user_no,nickname,join_date,update_date) " +
            "values(#{user_no} ,#{nickname} , now(), now())")
    int makeMemberProfile(@Param("user_no") Long userNo, @Param("nickname") String nickname);


    @Update("UPDATE member_profile SET " +
            "email_check=1 " +
            "WHERE user_no =#{user_no}")
    int setEmailVerificationStatus(@Param("user_no") Long userNo);


    @Update("UPDATE member_profile SET " +
            "email=#{email} " +
            "WHERE user_no =#{user_no}")
    int setEmailProfileByUserNo(@Param("email") String email, @Param("user_no") Long userNo);


    @Update("UPDATE member_profile SET " +
            "location=#{location} " +
            "WHERE user_no =#{user_no}")
    int setLocationByUserNo(@Param("location") String location, @Param("user_no") Long userNo);

    @Update("UPDATE member_profile SET " +
            "introduction=#{introduction} " +
            "WHERE user_no =#{user_no}")
    int setIntroductionByUserNo(@Param("introduction") String introduction, @Param("user_no") Long userNo);

    @Update("UPDATE member_profile SET " +
            "image_url=#{imgURL} " +
            "WHERE user_no =#{user_no}")
    int setImgUrlByUserNo(@Param("imgURL") String imgURL, @Param("user_no") Long userNo);
}
