package com.tu.goodsbuy.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class MemberProfile {

    private int profileId;
    private int userNo;
    private String nickName;
    private String joinDate;
    private String updateDate;
    private String email;
    private String phoneNumber;
    private String introduction;
    private String imageURL;
    private String birthday;
    private String location;

}
