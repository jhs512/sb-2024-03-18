package com.example.demo.domain.chat.chat.dto;

import com.example.demo.domain.chat.chat.entity.ChatMessage;
import com.example.demo.domain.chat.chat.entity.ChatRoom;
import lombok.Data;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Data
@NoArgsConstructor(access = PROTECTED)
public class ChatRoomDto {
    private long id;
    private String ownerName;
    private String name;

    public ChatRoomDto(ChatRoom room) {
        this.id = room.getId();
        this.ownerName = room.getOwner().getName();
        this.name = room.getName();
    }
}
