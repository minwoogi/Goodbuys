package com.tu.goodsbuy.util.filter;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;


/**
 * 로그인 햇을때 로그인 페이지 접근 불가
 */
@WebFilter(urlPatterns = {"/login.do", "/login"})
public class LoginSessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (req.getRequestURI().matches(".*(css|jpg|png|gif|js)")) {
            chain.doFilter(request, response);
            return;
        }

        if (Objects.nonNull(req.getSession(false).getAttribute("loginMember"))) {
            res.sendRedirect("goodsbuy/list");
            return;
        }
        chain.doFilter(request, response);
    }
}