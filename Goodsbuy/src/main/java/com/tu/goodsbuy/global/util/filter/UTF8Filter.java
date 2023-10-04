package com.tu.goodsbuy.global.util.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;


@WebFilter(filterName = "utf8Filter", urlPatterns = "/product/post")
public class UTF8Filter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        if (!req.getServletPath().contains("/js")) {
            req.setCharacterEncoding("utf-8");
            chain.doFilter(request, response);
        }

    }
}
