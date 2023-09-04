package com.tu.goodsbuy.util.filter;


import com.tu.goodsbuy.dto.MemberUser;
import com.tu.goodsbuy.util.ScriptWriterUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@WebFilter(urlPatterns = {"/info", "/myPage/*"})
public class LoginSessionFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        MemberUser loginMember = (MemberUser) req.getSession().getAttribute("loginMember");
        System.out.println("sdads");


        if (loginMember == null) {
            res = (HttpServletResponse) response;
            ScriptWriterUtil.writeAndRedirect(res, "This page requires login.", "/login");
        }
        chain.doFilter(request, response);
    }
}