package com.tu.goodsbuy.repository;

import com.tu.goodsbuy.model.dto.ChatRoom;
import com.tu.goodsbuy.repository.param.ChatRoomBuilder;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ChatRepository {


    @Select("SELECT * FROM chat_room WHERE user_no = #{userNo} or purchase_no = #{userNo}")
    List<ChatRoom> findAllRoomsByUserNo(Long userNo);

    @Select("SELECT * FROM chat_room WHERE chat_room_no = #{roomNo}")
    Optional<ChatRoom> findRoomByRoomNo(Long roomNo);


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
}
