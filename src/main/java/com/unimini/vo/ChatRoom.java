package com.unimini.vo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.unimini.enums.MessageType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChatRoom {

	private String roomId;
	private String name;
	private Set<WebSocketSession> sessions = new HashSet<>();

	public static ChatRoom create(String name) {
		ChatRoom chatRoom = new ChatRoom();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar calendar = Calendar.getInstance();
		
		chatRoom.roomId = UUID.randomUUID().toString() + "-" + simpleDateFormat.format(calendar.getTimeInMillis());
		chatRoom.name = name;
		return chatRoom;
	}

	public void handleMessage(WebSocketSession session, ChatMessage chatMessage, ObjectMapper objectMapper) throws IOException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		
		if (chatMessage.getType() == MessageType.ENTER) {
			sessions.add(session);
			chatMessage.setMessage(chatMessage.getWriter() + "님이 입장하셨습니다.");
		} else if (chatMessage.getType() == MessageType.LEAVE) {
			sessions.remove(session);
			chatMessage.setMessage(chatMessage.getWriter() + "님이 퇴장하셨습니다.");
		} else {
	        Map<String, Object> map = new HashMap<>();
	        map.put("name", chatMessage.getWriter());
	        map.put("msg", chatMessage.getMessage());
	        map.put("ppath", chatMessage.getPpath());
	        map.put("time", simpleDateFormat.format(chatMessage.getTimestamp()));
	        
	        Gson gson = new Gson();
	        JsonObject json = gson.toJsonTree(map).getAsJsonObject();
			
			chatMessage.setMessage(json.toString());
			send(chatMessage, objectMapper);
		}
		//send(chatMessage, objectMapper);
	}

	private void send(ChatMessage chatMessage, ObjectMapper objectMapper) throws IOException {
		TextMessage textMessage = new TextMessage(objectMapper.writeValueAsString(chatMessage.getMessage()));
		for (WebSocketSession sess : sessions) {
			sess.sendMessage(textMessage);
		}
	}

}
