package com.tu.goodsbuy.service;


import com.tu.goodsbuy.controller.param.ProductUpdateParam;
import com.tu.goodsbuy.global.exception.product.ProductUpdateException;
import com.tu.goodsbuy.global.exception.product.UpdateProductImageException;
import com.tu.goodsbuy.model.dto.ChatMessage;
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

    public ChatRoom findRoomByRoomNo(Long roomNo) {
        return chatRepository.findRoomByRoomNo(roomNo).orElseThrow();
    }

    public boolean isExistChatRoom(Long userNo, String productNo) {
        if (chatRepository.isExistChatRoom(userNo, productNo) == 1) {
            return true;
        }
        return false;
    }

    public void createChatRoom(ChatRoomBuilder chatRoomBuilder) {
        if (chatRepository.createChatRoom(chatRoomBuilder) == 0) {
            //TODO 예외 처리 해야함
        }
    }

    public List<ChatMessage> findAllMessageByChatRoomNo(String roomId) {
        return chatRepository.findAllMessageByChatRoomNo(roomId);
    }


    public void updateProductInfoChatRoomByProductUpdateParam(ProductUpdateParam productUpdateParam) {

        String productNo = productUpdateParam.getProductNo();
        String productName = productUpdateParam.getProductName();
        String productPrice = productUpdateParam.getProductPrice();

        if (chatRepository.updateProductInfoChatRoomByProductUpdateParam(productNo, productName, productPrice) == 0) {
            throw new ProductUpdateException();
        }
    }


    public void updateProductImgUrlByProductNo(String imgURL, String productNo) {
        chatRepository.updateProductImgUrlChatRoomByProductNo(imgURL, productNo);
    }


}
