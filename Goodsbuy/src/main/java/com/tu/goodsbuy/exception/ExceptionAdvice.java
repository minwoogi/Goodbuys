package com.tu.goodsbuy.exception;

import com.tu.goodsbuy.util.ScriptWriterUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;


@ControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler(DuplicatedLoginIdException.class)
    public String duplicatedIdError(RedirectAttributes rttr) {
        rttr.addFlashAttribute("msg", "계정 혹은 비밀번호가 일치하지 않습니다. 입력한 내용을 다시 확인해 주세요.");
        return "redirect:/login";
    }


    @ExceptionHandler({MakeMemberException.class, MakeMemberProfileException.class})
    public void makeMemberError(HttpServletResponse response) throws IOException {
        ScriptWriterUtil.writeAndRedirect(response, "회원가입 실패", "/register");
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException e) {
        System.out.println("e = " + e);
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
