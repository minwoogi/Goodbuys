package com.tu.goodsbuy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
public class ChatRoom {


    private Long chatRoomNo; //채팅방번호
    private Long productNo; //상품번호
    private Long userNo; //판매자 유저번호
    private String userNickname; // 판매자 닉네임
    private String userProfileUrl; // 판매자 프로필 사진 url
    private Long purchaseNo; //구매자 유저번호
    private String purchaseNickname; //구매자 닉네임
    private String purchaseProfileUrl; // 구매자 프로필 url
    private Date createdDate;  //채팅방 생성 날짜
    private Date lastModifiedDate; // 마지막 수정 날짜
    private int notReadCount; // 안읽은 메세지 수
    private String productImageUrl; // 상품 이미지 url
    private String productName; //상품이름
    private String productPrice; //상품 번호
    private short userState; // 판매자 채팅방 삭제 여부
    private short purchaseState; // 구매자 채팅방 삭제 여부
}
