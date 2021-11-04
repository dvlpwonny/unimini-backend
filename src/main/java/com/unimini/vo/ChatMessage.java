package com.unimini.vo;

import com.unimini.enums.MessageType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChatMessage {

    private String chatRoomId;
    private String writer;
    private String message;
    private MessageType type;

}
