package com.example.demo.domain.chat.chat.dto;

import com.example.demo.domain.chat.chat.entity.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Data
@NoArgsConstructor(access = PROTECTED)
public class ChatMessageDto {
    private long id;
    private long chatRoomId;
    private long writerId;
    private String writerName;
    private String body;

    public ChatMessageDto(ChatMessage message) {
        this.id = message.getId();
        this.chatRoomId = message.getChatRoom().getId();
        this.writerId = message.getWriter().getId();
        this.writerName = message.getWriter().getName();
        this.body = message.getBody();
    }
}
