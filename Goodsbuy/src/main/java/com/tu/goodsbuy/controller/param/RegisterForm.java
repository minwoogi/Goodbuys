package com.tu.goodsbuy.controller.param;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterForm {

    private String userId;
    private String userPwd;
    private String confirmPassword;
    private String birth;
    private String nickname;


}
