package com.tu.goodsbuy.util.filter;

import com.tu.goodsbuy.util.ScriptWriterUtil;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


/**
 * 로그인 세션이 필요한 페이지면 로그인페이지로 보내기
 **/
@WebFilter(urlPatterns = "/goodsbuy/profile")
public class LoginCheckFilter implements Filter {

//    List<String> backList = List.of("");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
//        if (backList.contains(req.getServletPath()) && Objects.isNull(req.getSession(false))) {
//            ScriptWriterUtil.writeAndRedirect(res, "로그인이 필요한 페이지입니다.", "/login");
//            return;
//        }
        if (req.getServletPath().contains("/js")) {
            chain.doFilter(request, response);
        }

        if (Objects.isNull(req.getSession(false).getAttribute("loginMember"))) {
            ScriptWriterUtil.writeAndRedirect(res, "로그인이 필요한 페이지입니다.", "/login");
            return;
        }
        chain.doFilter(request, response);
    }
}