package com.tu.goodsbuy.repository;

import com.tu.goodsbuy.model.dto.ChatRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChatRepository {


    @Select("SELECT * FROM chat_room WHERE user_no = #{userNo} or purchase_no = #{userNo}")
    List<ChatRoom> findAllRoomsByUserNo(Long userNo);


}
