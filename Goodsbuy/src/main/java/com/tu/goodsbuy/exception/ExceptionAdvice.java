package com.tu.goodsbuy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@ControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler(DuplicatedLoginIdException.class)
    public String duplicatedIdError(RedirectAttributes rttr) {
        rttr.addFlashAttribute("msg", "계정 혹은 비밀번호가 일치하지 않습니다. 입력한 내용을 다시 확인해 주세요.");
        return "redirect:/login";
    }


//    @ExceptionHandler(BindException.class)
//    public String errorPage(BindException e, RedirectAttributes ra, HttpServletRequest req) {
//        ra.addFlashAttribute("errors", e.getBindingResult());
//        String servletPath = req.getServletPath();
//        return "redirect:" + servletPath;
//    }
//
//    @ExceptionHandler({
//            UserNotFoundException.class, ExistIdException.class
//    })
//    public String loginRegisterError(Model model, Exception e) {
//        model.addAttribute("globalError", e.getMessage());
//        return "login-form";
//    }
//
//    @ExceptionHandler({
//            UserPermissionException.class,
//            NotFoundParentBoardException.class
//    })
//    public String requestError(Model model, Exception e) {
//        model.addAttribute("error", e.getMessage());
//        return "error";
//    }
}
