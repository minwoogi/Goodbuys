package com.tu.goodsbuy.repository;

import com.tu.goodsbuy.model.dto.ChatRoom;
import com.tu.goodsbuy.repository.param.ChatRoomBuilder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChatRepository {


    @Select("SELECT * FROM chat_room WHERE user_no = #{userNo} or purchase_no = #{userNo}")
    List<ChatRoom> findAllRoomsByUserNo(Long userNo);


    @Insert("INSERT INTO " +
            "chat_room(product_no, user_no,user_nickname, user_profile_url ," +
            "purchase_no, purchase_nickname,purchase_profile_url ," +
            "product_image_url, product_name, product_price) " +
            "values(#{productNo},#{userNo},#{userNickname},#{userProfileUrl}," +
            "#{purchaseNo},#{purchaseNickname},#{purchaseProfileUrl}," +
            "#{productImageUrl},#{productName},#{productPrice})")
    int createChatRoom(ChatRoomBuilder chatRoomBuilder);


}
