package com.tu.goodsbuy.dto;


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
    private short locationNo;

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
                ", locationNo=" + locationNo +
                '}';
    }
}
