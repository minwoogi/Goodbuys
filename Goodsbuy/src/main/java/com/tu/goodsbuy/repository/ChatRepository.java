package com.tu.goodsbuy.repository;

import com.tu.goodsbuy.model.dto.ChatMessage;
import com.tu.goodsbuy.model.dto.ChatRoom;
import com.tu.goodsbuy.repository.param.ChatRoomBuilder;
import com.tu.goodsbuy.repository.param.InsertChatMessageDto;
import com.tu.goodsbuy.service.ChatService;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ChatRepository {


    @Select("SELECT * FROM chat_room WHERE user_no = #{userNo} or purchase_no = #{userNo}")
    List<ChatRoom> findAllRoomsByUserNo(Long userNo);

    @Select("SELECT * FROM chat_room WHERE chat_room_no = #{roomNo}")
    Optional<ChatRoom> findRoomByRoomNo(Long roomNo);

    @Select("SELECT * FROM chat_message WHERE chat_room_no = #{roomNo} ORDER BY created_date asc")
    List<ChatMessage> findAllMessageByChatRoomNo(String roomNo);


    @Insert("INSERT INTO " +
            "chat_room(product_no, user_no,user_nickname, user_profile_url ," +
            "purchase_no, purchase_nickname,purchase_profile_url ," +
            "product_image_url, product_name, product_price) " +
            "values(#{productNo},#{userNo},#{userNickname},#{userProfileUrl}," +
            "#{purchaseNo},#{purchaseNickname},#{purchaseProfileUrl}," +
            "#{productImageUrl},#{productName},#{productPrice})")
    int createChatRoom(ChatRoomBuilder chatRoomBuilder);


    @Select("SELECT COUNT(*)>0  FROM chat_room " +
            "WHERE (user_no = #{userNo} OR purchase_no=#{userNo}) AND product_no=#{productNo}")
    int isExistChatRoom(@Param("userNo") Long userNo, @Param("productNo") String productNo);


    @Update("UPDATE chat_room " +
            "SET product_name = #{productName}, " +
            "    product_price = #{productPrice} " +
            "WHERE product_no = #{productNo}")
    int updateProductInfoChatRoomByProductUpdateParam(@Param("productNo") String productNo, @Param("productName") String productName,
                                                      @Param("productPrice") String productPrice);


    @Update("UPDATE chat_room SET product_image_url=#{imageURL} WHERE product_no =#{productNo}")
    int updateProductImgUrlChatRoomByProductNo(String imgURL, String productNo);


    /*@Options(useGeneratedKeys = true, keyProperty = "messageNo", keyColumn = "message_no")
    @Insert("INSERT INTO chat_message(chat_room_no , created_date , content, sender_id , sender_nickname, recipient_id )" +
            " VALUES(#{chatRoomNo} , now() ,#{content}, #{senderId} , #{nickname}, #{recipientId})")
    void createChatMessage(InsertChatMessageDto insertChatMessageDto);*/


    /*@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "message_no", before = false, resultType = Long.class)
    void createChatMessage(@Param("roomNo") String roomNo, @Param("content") String content,
                           @Param("senderId") Long senderId,
                           @Param("nickname") String senderNickname, @Param("recipientId") Long recipientId);
*/


    @Insert("INSERT INTO chat_message(chat_room_no , created_date , content, sender_id , sender_nickname, recipient_id )" +
            " VALUES(#{chatRoomNo} , now() ,#{content}, #{senderId} , #{senderNickname}, #{recipientId})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "messageNo", before = false, resultType = Long.class)
    void createChatMessage(InsertChatMessageDto insertChatMessageDto);


    @Select("SELECT * FROM chat_message WHERE message_no = #{messageNo}")
    Optional<ChatMessage> getChatMessageByMessageNo(Long messageNo);
}
