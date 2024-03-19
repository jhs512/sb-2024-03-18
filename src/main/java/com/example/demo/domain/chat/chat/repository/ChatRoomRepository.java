package com.example.demo.domain.chat.chat.repository;


import com.example.demo.domain.chat.chat.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
