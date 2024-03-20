package com.example.demo.domain.chat.chat.entity;

import com.example.demo.domain.member.member.entity.Member;
import com.example.demo.global.jpa.entity.BaseTime;
import jakarta.persistence.Column;
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
public class ChatRoom extends BaseTime {
    @ManyToOne
    private Member owner;
    private String name;
    @Column(columnDefinition = "BOOLEAN default true")
    private boolean published;
}
