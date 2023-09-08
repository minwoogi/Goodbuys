package com.tu.goodsbuy.advice;

import com.tu.goodsbuy.exception.DuplicatedLoginIdException;
import com.tu.goodsbuy.exception.MakeMemberException;
import com.tu.goodsbuy.exception.MakeMemberProfileException;
import com.tu.goodsbuy.exception.NicknameDuplicateException;
import com.tu.goodsbuy.util.ScriptWriterUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Slf4j
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(DuplicatedLoginIdException.class)
    public String duplicatedIdError(RedirectAttributes retry, Exception e) {
        retry.addFlashAttribute("msg", e.getMessage());
        return "redirect:/login";
    }

    @ExceptionHandler(NicknameDuplicateException.class)
    public void duplicatedNickNameError(HttpServletResponse response) throws IOException {
        ScriptWriterUtil.writeAndRedirect(response, "이미 사용중인 닉네임 입니다.", "/myPage");
    }

    @ExceptionHandler({MakeMemberException.class, MakeMemberProfileException.class})
    public void makeMemberError(HttpServletResponse response) throws IOException {
        ScriptWriterUtil.writeAndRedirect(response, "회원가입 실패", "/register");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException e) {
        e.printStackTrace();
        return "errorPage";
    }

    // 데이터베이스오류
    @ExceptionHandler(DataAccessException.class)
    public String handleDataAccessException(DataAccessException e) {
        e.printStackTrace();
        return "redirect:/errorPage";
    }

    // 500에러처리
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        e.printStackTrace();
        return "redirect:/errorPage";
    }


}
