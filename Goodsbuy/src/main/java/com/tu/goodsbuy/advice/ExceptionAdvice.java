package com.tu.goodsbuy.advice;

import com.tu.goodsbuy.global.exception.file.NotImageFileException;
import com.tu.goodsbuy.global.exception.product.ProductCreateException;
import com.tu.goodsbuy.global.exception.product.ProductNotFoundException;
import com.tu.goodsbuy.global.exception.profile.*;
import com.tu.goodsbuy.global.exception.user.DuplicatedLoginIdException;
import com.tu.goodsbuy.global.exception.user.MakeMemberException;
import com.tu.goodsbuy.global.util.ScriptWriterUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
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

    /*@ExceptionHandler(NoProductListException.class)
    public String noProductListError(Exception e, Model model) {

        model.addAttribute("msg",e.getMessage());

        return "product/list";
    }*/

    @ExceptionHandler(NicknameDuplicateException.class)
    public void duplicatedNickNameError(HttpServletResponse response, Exception e) throws IOException {
        ScriptWriterUtil.writeAndRedirect(response, e.getMessage(), "/goodsbuy/profile");
    }

    @ExceptionHandler({MakeMemberException.class, MakeMemberProfileException.class})
    public void makeMemberError(HttpServletResponse response) throws IOException {
        ScriptWriterUtil.writeAndRedirect(response, "회원가입 실패", "/register");
    }

    @ExceptionHandler(EmailStatusUpdateException.class)
    public String emailStatusError(EmailStatusUpdateException e) {
        log.error(e.getMessage() + " | LocationUpdateException");
        return "errorPage";
    }

    @ExceptionHandler(LocationUpdateException.class)
    public String locationUpdateError(LocationUpdateException e) {
        log.error(e.getMessage());
        return "errorPage";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String productNotFoundError(ProductNotFoundException e) {

        log.error(e.getMessage());
        return "errorPage";
    }

    @ExceptionHandler(ProductCreateException.class)
    public String productCreationError(ProductCreateException e) {
        log.error(e.getMessage());
        return "errorPage";
    }


    @ExceptionHandler(IntroductionUpdateException.class)
    public String introUpdateError(IntroductionUpdateException e) {
        log.error(e.getMessage());
        return "errorPage";
    }

    @ExceptionHandler(EmailSendFailedException.class)
    public void sendEmailError(HttpServletResponse response, EmailSendFailedException e) throws IOException {
        ScriptWriterUtil.writeAndRedirect(response, e.getMessage(), "/email");
    }

    //404에러
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException e) {
        log.error(e.getMessage());
        return "errorPage";
    }

    // 데이터베이스오류
    @ExceptionHandler(DataAccessException.class)
    public String handleDataAccessException(DataAccessException e) {
        log.error(e.getMessage());
        return "redirect:/errorPage";
    }

    // 500에러처리
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        log.error(e.getMessage());
        return "redirect:/errorPage";
    }

    @ExceptionHandler(NotImageFileException.class)
    public void notImageFileError(HttpServletResponse response, Exception e) throws IOException {
        ScriptWriterUtil.writeScript(response, e.getMessage());
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<String> maxImageSizeError(Exception e) {
        log.error("maxImageSizeError!!");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
