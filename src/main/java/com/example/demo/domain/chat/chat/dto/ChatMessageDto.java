package com.example.demo.domain.chat.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatMessageDto {
    private long id;
    private long chatRoomId;
    private String writerName;
    private String body;
}