package com.unimini.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimini.mapper.ChatMapper;
import com.unimini.vo.ChatMessage;
import com.unimini.vo.ChatRoom;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatService {

	@Autowired
	ChatMapper chatMapper;

    private Map<String, ChatRoom> chatRoomMap;

    @PostConstruct
    private void init(){
        chatRoomMap = new LinkedHashMap<>();

    	List<String> ids = chatMapper.findAllRoomIds();
    	for(String id : ids) {
    		ChatRoom chatRoom = chatMapper.findRoomById(id);
    		chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
    	}
    }

    public List<ChatRoom> findAllRoom(){
        List chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }

    public ChatRoom findRoomById(String id){
        return chatRoomMap.get(id);
    }

    public ChatRoom createChatRoom(String name){
        ChatRoom chatRoom = ChatRoom.create(name);
        chatMapper.createChatRoom(chatRoom);
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }

	public void insertMessage(ChatMessage chatMessage) {
		chatMapper.insertMessage(chatMessage);
	}

}
