package com.tu.goodsbuy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
public class ChatMessage {

    private Long messageNo; // 메세지 ID
    private Long chatRoomNo; // 채팅방 ID
    private Date createdDate; // 생성 날자
    private String content; // 채팅내용
    private short isRead; // 읽음 여부
    private Long senderId; // 메세지 발신자
    private String senderNickname; //메세지 발신자 닉네임
    private Long recipientId; // 메세지 수신자

}
