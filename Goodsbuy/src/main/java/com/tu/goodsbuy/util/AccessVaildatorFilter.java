package com.tu.goodsbuy.util;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class AccessVaildatorFilter implements Filter {

    private List<String> loginSessionRequiredLinks;

    private List<String> invaildAccessLinks;

    public AccessVaildatorFilter() {
        loginSessionRequiredLinks = new ArrayList<String>();
        loginSessionRequiredLinks.add("/mypage.jsp");
        loginSessionRequiredLinks.add("/info.jsp");
        loginSessionRequiredLinks.add("/write.jsp");
        loginSessionRequiredLinks.add("/article");
        loginSessionRequiredLinks.add("update.jsp");
        loginSessionRequiredLinks.add("logOut.do");

        invaildAccessLinks = new ArrayList<String>();
        invaildAccessLinks.add("/update.do");
        invaildAccessLinks.add("/delete.do");
        invaildAccessLinks.add("/scrap.do");
        invaildAccessLinks.add("/deleteScrap.do");
        invaildAccessLinks.add("/write.do");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        String uri = req.getRequestURI();

//        if (loginSessionRequiredLinks.contains(uri)) {
//            session = req.getSession();
//            if (Objects.isNull(session.getAttribute("loginMember"))) {
//                res = (HttpServletResponse) response;
//                ScriptWriterUtil.(res, "This page requires login.", "login.jsp");
//            }
//        }
//
//        if (invaildAccessLinks.contains(uri)) {
//            session = req.getSession();
//            if (Objects.isNull(session.getAttribute("loginMember"))) {
//                ScriptWriterUtil.writeAndRedirect(res, "잘못된 접근", "login.jsp");
//            }
//        }
//
//        if (invaildAccessLinks.contains(uri)) {
//            if (req.getMethod().equals("GET")) {
//                ScriptWriterUtil.writeAndRedirect(res, "잘못된 접근", "/list");
//            }
//        }
//
//
//        if (uri.contains("/login.do")) {
//            session = req.getSession();
//            if (Objects.nonNull(session.getAttribute("loginMember"))) {
//                ScriptWriterUtil.writeAndRedirect(res, "이미 로그인된 ID", "/list");
//            }
//        }
//
//        if (uri.contains("/login.jsp")) {
//            session = req.getSession();
//            if (Objects.nonNull(session.getAttribute("loginMember"))) {
//                ScriptWriterUtil.writeAndRedirect(res, "이미 로그인된 ID == LoginPage접근불가", "/list");
//            }
//        }

        chain.doFilter(request, response);
    }
}
