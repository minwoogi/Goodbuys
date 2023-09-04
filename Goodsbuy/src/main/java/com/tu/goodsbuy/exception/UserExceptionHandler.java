package com.tu.goodsbuy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class UserExceptionHandler {


    @ExceptionHandler(DuplicatedLoginIdException.class)
    public void duplicatedException(RedirectAttributes rttr) {


    }


}
