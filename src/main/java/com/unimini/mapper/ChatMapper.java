package com.unimini.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.unimini.vo.ChatMessage;
import com.unimini.vo.ChatRoom;

@Repository
@Mapper
public interface ChatMapper {
	
	List<String> findAllRoomIds();
	ChatRoom findRoomById(String id);
	void createChatRoom(ChatRoom chatRoom);
	void insertMessage(ChatMessage chatMessage);

}
