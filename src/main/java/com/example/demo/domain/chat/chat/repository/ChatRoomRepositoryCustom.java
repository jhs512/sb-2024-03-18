package com.example.demo.domain.chat.chat.repository;

import com.example.demo.domain.chat.chat.entity.ChatRoom;
import com.example.demo.domain.member.member.entity.Member;
import com.example.demo.standard.base.KwTypeV2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChatRoomRepositoryCustom {
    Page<ChatRoom> findByKw(KwTypeV2 kwType, String kw, Member owner, Boolean published, Pageable pageable);
}
