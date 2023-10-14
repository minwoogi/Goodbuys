package com.tu.goodsbuy.service;


import com.tu.goodsbuy.controller.param.ProductUpdateParam;
import com.tu.goodsbuy.global.exception.product.ProductUpdateException;
import com.tu.goodsbuy.global.exception.profile.GetProfileException;
import com.tu.goodsbuy.model.dto.ChatMessage;
import com.tu.goodsbuy.model.dto.ChatRoom;
import com.tu.goodsbuy.model.dto.MemberProfile;
import com.tu.goodsbuy.repository.param.InsertChatMessageDto;
import com.tu.goodsbuy.repository.ChatRepository;
import com.tu.goodsbuy.repository.param.ChatRoomBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ChatService {

    private final ChatRepository chatRepository;


    @Transactional(readOnly = true)
    public List<ChatRoom> findAllRoomByUserNo(Long userNo) {
        List<ChatRoom> rooms = chatRepository.findAllRoomsByUserNo(userNo);
        Collections.reverse(rooms);

        return rooms;
    }

    @Transactional(readOnly = true)
    public ChatRoom findRoomByRoomNo(Long roomNo) {
        return chatRepository.findRoomByRoomNo(roomNo).orElseThrow();
    }


    @Transactional
    public boolean isExistChatRoom(Long userNo, String productNo) {
        if (chatRepository.isExistChatRoom(userNo, productNo) == 1) {
            return true;
        }
        return false;
    }

    @Transactional
    public void createChatRoom(ChatRoomBuilder chatRoomBuilder) {
        if (chatRepository.createChatRoom(chatRoomBuilder) == 0) {
            //TODO 예외 처리 해야함
        }
    }

    @Transactional(readOnly = true)
    public List<ChatMessage> findAllMessageByChatRoomNo(String roomId) {
        return chatRepository.findAllMessageByChatRoomNo(roomId);
    }


    @Transactional
    public void updateProductInfoChatRoomByProductUpdateParam(ProductUpdateParam productUpdateParam) {

        String productNo = productUpdateParam.getProductNo();
        String productName = productUpdateParam.getProductName();
        String productPrice = productUpdateParam.getProductPrice();

        if (chatRepository.updateProductInfoChatRoomByProductUpdateParam(productNo, productName, productPrice) == 0) {
            throw new ProductUpdateException();
        }
    }


    @Transactional
    public void updateProductImgUrlByProductNo(String imgURL, String productNo) {
        chatRepository.updateProductImgUrlChatRoomByProductNo(imgURL, productNo);
    }

    @Transactional
    public ChatMessage MakeSendMessage(String roomNo, String content, Long senderId, String senderNickname, Long recipientId) {

        InsertChatMessageDto insertChatMessageDto = InsertChatMessageDto.builder().messageNo(null)
                .chatRoomNo(roomNo).content(content).senderId(senderId).senderNickname(senderNickname)
                .recipientId(recipientId).build();

        /*chatRepository.createChatMessage(roomNo, content, senderId, senderNickname, recipientId);*/
        chatRepository.createChatMessage(insertChatMessageDto);


        return chatRepository.getChatMessageByMessageNo(insertChatMessageDto.getMessageNo()).orElseThrow();
    }

    @Transactional(readOnly = true)
    public Long getRecipientIdBySenderNo(Long roomNo, Long senderId) {

        ChatRoom chatRoom = chatRepository.findRoomByRoomNo(roomNo).orElseThrow();

        if (senderId == chatRoom.getUserNo()) {
            return chatRoom.getPurchaseNo();
        }

        return chatRoom.getUserNo();
    }


}
