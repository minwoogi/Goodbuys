package com.tu.goodsbuy.util;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "utf8Filter", urlPatterns = "/*")
public class UTF8Filter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        req.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);

    }
}
