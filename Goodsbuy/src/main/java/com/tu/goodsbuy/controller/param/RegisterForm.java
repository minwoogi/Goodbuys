package com.tu.goodsbuy.controller.param;


import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RegisterForm {


    @Pattern(regexp = "^[a-zA-Z0-9]{4,20}$", message = "아이디 규칙에 맞게 입력해주세요")
    private String userId;


    @Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,20}$", message = "비밀번호 규칙에 맞게 입력해주세요")
    private String userPwd;


    @Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,20}$", message = "비밀번호 규칙에 맞게 입력해주세요")
    private String confirmPassword;


    @Pattern(regexp = "^[0-9]{8}$", message = "생일 형식에 맞게 작성해주세요")
    private String birth;


    @Pattern(regexp = "^[a-zA-Z0-9가-힣]{2,20}$", message = "닉네임 형식에 맞게 작성해주세요.")
    private String nickname;


}
