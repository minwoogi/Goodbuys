package com.tu.goodsbuy.controller.param;


import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LoginForm {


    @Pattern(regexp = "^[a-zA-Z0-9]{4,20}$", message = "계정 혹은 비밀번호가 일치하지 않습니다. 입력한 내용을 다시 확인해 주세요.")
    private String username;

    @Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,20}$",
            message = "계정 혹은 비밀번호가 일치하지 않습니다. 입력한 내용을 다시 확인해 주세요.")
    private String password;


}
