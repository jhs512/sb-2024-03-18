package com.example.demo.chat.service;

import com.example.demo.chat.entity.ChatMessage;
import com.example.demo.chat.entity.ChatRoom;
import com.example.demo.chat.repository.ChatMessageRepository;
import com.example.demo.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatService {
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    public Optional<ChatRoom> findRoomById(long roomId) {
        return chatRoomRepository.findById(roomId);
    }

    @Transactional
    public ChatRoom createRoom(String name) {
        ChatRoom chatRoom = ChatRoom
                .builder()
                .name(name)
                .build();

        return chatRoomRepository.save(chatRoom);
    }

    @Transactional
    public ChatMessage writeMessage(ChatRoom room, String writerName, String body) {
        ChatMessage chatMessage = ChatMessage
                .builder()
                .chatRoom(room)
                .writerName(writerName)
                .body(body)
                .build();

        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> findMessagesByRoomId(long roomId) {
        return chatMessageRepository.findByChatRoomId(roomId);
    }

    public int count() {
        return (int) chatRoomRepository.count();
    }
}
