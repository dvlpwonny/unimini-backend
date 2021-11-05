package com.unimini.vo;

import java.util.Date;

import com.unimini.enums.MessageType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChatMessage {

	private Date timestamp;
    private String chatRoomId;
    private String writer;
    private String message;
    private MessageType type;

}
