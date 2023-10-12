package com.tu.goodsbuy.global.util.filter;

import com.tu.goodsbuy.service.ChatService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;

import java.io.IOException;


@WebFilter(urlPatterns = {"/chat/*"})
@RequiredArgsConstructor
@Order(3)
public class ChatEnterFilter implements Filter {

    private final ChatService chatService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();


        // /chat/숫자 패턴에 대한 처리
        // 예: /chat/123 에 대한 동작
        if (requestURI.matches("^/chat/\\d+$")) { // 임의 접근


        }

        chain.doFilter(request, response);


    }
}
