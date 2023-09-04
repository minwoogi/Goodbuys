package com.tu.goodsbuy.util.interceptor;

import com.tu.goodsbuy.dto.MemberUser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        MemberUser memberUser = (MemberUser) request.getSession().getAttribute("loginMember");
//        if (memberUser == null) {
//            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/error-page/401.jsp");
//            response.setStatus(401);
//            rd.forward(request, response);
//            return false;
//        }
//        return true;
//    }
}
