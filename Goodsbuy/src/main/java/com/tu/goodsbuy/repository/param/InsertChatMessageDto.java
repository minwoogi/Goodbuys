package com.tu.goodsbuy.repository.param;


import lombok.*;

import java.util.Date;


@Builder
@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
public class InsertChatMessageDto {

    Long messageNo;
    String chatRoomNo;
    String content;
    short isRead;
    Long senderId;
    String senderNickname;
    Long recipientId;


}
