package com.tu.goodsbuy.util;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebFilter(urlPatterns = "/index")
public class LoginSessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        if (Objects.isNull(session.getAttribute("loginMember"))) {
            PrintWriter writer = res.getWriter();
            writer.println("<script>alert('login이 필요한 페이지입니다.');</script>");
            res.sendRedirect("loginPage.jsp");
            writer.close();
        }
        chain.doFilter(request, response);
    }
}
