package com.tu.goodsbuy.global.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//    private final StompHandler stompHandler;


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 클라이언트가 메시지 발행시 /pub/* 경로로 전송
        registry.setApplicationDestinationPrefixes("/pub");


        // 클라이언트가 메시지를 /sub/* 경로로 구독
        registry.enableSimpleBroker("/sub");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // without SockJS
        registry.addEndpoint("/chat");

        // with SockJS
        registry.addEndpoint("/chat")
                .withSockJS()
                .setDisconnectDelay(15 * 1000)
                .setHeartbeatTime(5 * 1000);
    }



    /*@Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(stompHandler);
    }*/


    /*@Bean
    public WebSocketMessageBrokerStats localWebSocketMessageBrokerStats(WebSocketMessageBrokerStats webSocketMessageBrokerStats) {
        webSocketMessageBrokerStats.setLoggingPeriod(30 * 1000);
        return webSocketMessageBrokerStats;
    }*/

}

