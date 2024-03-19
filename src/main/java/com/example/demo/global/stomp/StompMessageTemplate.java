package com.example.demo.global.stomp;

public interface StompMessageTemplate {
    void convertAndSend(String type, String destination, Object payload);
}
