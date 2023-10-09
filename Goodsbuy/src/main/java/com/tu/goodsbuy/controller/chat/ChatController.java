package com.tu.goodsbuy.controller.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class ChatController {


//    private final SimpMessageSendingOperations messagingTemplate;
//
//    @EventListener
//    public void handleWebSocketConnecListener(SessionConnectEvent event) {
//        log.info("Received a new web socket connection");
//    }

    @GetMapping("/chat")
    public String getChat() {

        return "users/chat";
    }
}
