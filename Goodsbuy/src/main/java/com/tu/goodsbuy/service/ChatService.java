package com.tu.goodsbuy.service;


import com.tu.goodsbuy.model.dto.ChatRoom;
import com.tu.goodsbuy.repository.ChatRepository;
import com.tu.goodsbuy.repository.param.ChatRoomBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;


    public List<ChatRoom> findAllRoomByUserNo(Long userNo) {
        List<ChatRoom> rooms = chatRepository.findAllRoomsByUserNo(userNo);
        Collections.reverse(rooms);

        return rooms;
    }

    public void createChatRoom(ChatRoomBuilder chatRoomBuilder) {
        if (chatRepository.createChatRoom(chatRoomBuilder) == 0) {

        }
    }


}
