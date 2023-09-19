package com.tu.goodsbuy.controller.user.post;

import com.tu.goodsbuy.util.ScriptWriterUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;


@Controller
public class EmailPostController {


    @PostMapping("/check-email")
    public String checkEmailCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (!(Boolean) request.getSession().getAttribute("emailAuth")) {
            ScriptWriterUtil.writeAndRedirect(response, "email 인증을 완료하지 않았습니다.", "/register");
        }

        request.getSession().removeAttribute("emailAuth");
        return "/goodsbuy/list";
    }
}
