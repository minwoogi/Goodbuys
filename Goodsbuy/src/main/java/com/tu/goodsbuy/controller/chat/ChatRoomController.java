package com.tu.goodsbuy.controller.chat;

import com.tu.goodsbuy.model.dto.ChatRoom;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
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


    @GetMapping("/chat")
    public String getChat(@SessionAttribute(value = "loginMember") MemberUser loginMember, Model model) {

        List<ChatRoom> rooms = chatService.findAllRoomByUserNo(loginMember.getUserNo());
        model.addAttribute("chatroom", rooms);

        log.info("date --> {}", rooms.get(0).getLastModifiedDate());

        return "chat/chatRoom";
    }


    // /pub/enter/{roomId} request 요청
    // /sub/chat/{roomId} response
    @MessageMapping("/enter/{roomId}")
    @SendTo("/sub/chat/{roomId}")
    public String enter(@DestinationVariable("roomId") Long roomId, Long memberId) {
        log.info("enter room : " + roomId + ", member : " + memberId);


        return "System : " + memberId + "님 입장";
    }


    @GetMapping("/alertChat")
    public String getAlertChat() {
        return "chat/alertChat";
    }

    @GetMapping("/alertChat2")
    public String getAlertChat2() {
        return "chat/alertChat2";
    }
}
