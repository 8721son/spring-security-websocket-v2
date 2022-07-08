package com.example.websocketchat.dto;

import lombok.Getter;
import java.util.UUID;

@Getter
public class Room {
    private String roomId;
    private String name;
    public static Room create(String name) {
        Room chatRoom = new Room();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }
}
