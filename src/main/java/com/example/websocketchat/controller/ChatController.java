package com.example.websocketchat.controller;

import com.example.websocketchat.dto.Room;
import com.example.websocketchat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public Room createRoom(@RequestParam String name) {
        return chatService.createRoom(name);
    }

    @GetMapping
    public List<Room> findAllRoom() {
        return chatService.findAllRoom();
    }
}