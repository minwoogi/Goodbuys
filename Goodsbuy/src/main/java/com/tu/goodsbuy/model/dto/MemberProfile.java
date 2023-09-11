package com.tu.goodsbuy.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "MemberProfile{" +
                "profileId=" + profileId +
                ", userNo=" + userNo +
                ", nickName='" + nickName + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", introduction='" + introduction + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", birthday='" + birthday + '\'' +
                ", location=" + location +
                '}';
    }
}
