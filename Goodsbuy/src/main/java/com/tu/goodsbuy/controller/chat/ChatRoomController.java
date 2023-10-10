package com.tu.goodsbuy.controller.chat;

import com.tu.goodsbuy.model.dto.ChatRoom;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatService chatService;


//    private final SimpMessageSendingOperations messagingTemplate;
//
//    @EventListener
//    public void handleWebSocketConnecListener(SessionConnectEvent event) {
//        log.info("Received a new web socket connection");
//    }

    @GetMapping("/rooms")
    public String getChat(@SessionAttribute(value = "loginMember") MemberUser loginMember, Model model) {

        List<ChatRoom> rooms = chatService.findAllRoomByUserNo(loginMember.getUserNo());
        model.addAttribute("chatroom", rooms);

        return "chat/chatRoom";
    }

    /*@MessageMapping("/chat.sendMessage")
    @SendTo("/chat/purchaseNo")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessage;
    }*/


    @GetMapping("/alertChat")
    public String getAlertChat() {
        return "chat/alertChat";
    }

    @GetMapping("/alertChat2")
    public String getAlertChat2() {
        return "chat/alertChat2";
    }
}
