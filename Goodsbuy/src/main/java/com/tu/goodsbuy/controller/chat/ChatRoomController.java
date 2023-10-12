package com.tu.goodsbuy.controller.chat;

import com.tu.goodsbuy.model.dto.ChatRoom;
import com.tu.goodsbuy.model.dto.MemberUser;
import com.tu.goodsbuy.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@Slf4j
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatService chatService;


    @GetMapping("/chat")
    public String getChat(@SessionAttribute(value = "loginMember") MemberUser loginMember, Model model) {

        List<ChatRoom> rooms = chatService.findAllRoomByUserNo(loginMember.getUserNo());
        model.addAttribute("chatroom", rooms);

        return "chat/chatRoom";
    }


    // /pub/enter/{roomId} request 요청
    // /sub/chat/{roomId} response
    @MessageMapping("/enter/{roomId}")
    @SendTo("/sub/chat/{roomId}")
    public String enter(@DestinationVariable("roomId") String roomId, String memberId) {

        log.info("enter room : " + roomId + ", member : " + memberId);


        return "System : " + memberId + "님 입장";
    }


    @ResponseBody
    @PostMapping("/chat/render")
    public ResponseEntity<ChatRoom> renderChatRoom(@RequestBody Map<String, String> roomId) {
        ChatRoom chatRoom = chatService.findRoomByRoomNo(Long.valueOf(roomId.get("roomId")));
        return ResponseEntity.ok(chatRoom);
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
