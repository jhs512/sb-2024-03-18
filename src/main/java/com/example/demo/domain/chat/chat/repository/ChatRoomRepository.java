package com.example.demo.domain.chat.chat.repository;


import com.example.demo.domain.chat.chat.entity.ChatRoom;
import com.example.demo.domain.member.member.entity.Member;
import com.example.demo.standard.base.KwTypeV2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long>, ChatRoomRepositoryCustom {

}
