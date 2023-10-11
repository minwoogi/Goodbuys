package com.tu.goodsbuy.repository.param;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomBuilder {

    private String productNo;
    private Long userNo;
    private String userNickname;
    private String userProfileUrl;
    private Long purchaseNo;
    private String purchaseNickname;
    private String purchaseProfileUrl;
    private String productImageUrl;
    private String productName;
    private String productPrice;
}
