package com.example.demo.domain.chat.entity;

import com.example.demo.domain.member.member.entity.Member;
import com.example.demo.global.jpa.entity.BaseTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Getter
@Setter
public class ChatMessage extends BaseTime {
    @ManyToOne
    private ChatRoom chatRoom;
    @ManyToOne
    private Member writer;
    private String body;
}
