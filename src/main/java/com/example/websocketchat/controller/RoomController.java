package com.example.websocketchat.controller;

import com.example.websocketchat.dto.Room;
import com.example.websocketchat.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class RoomController {
    private final RoomRepository roomRepository;

    @GetMapping("/room")
    public String rooms(Model model) {
        return "/chat/room";
    }

    @GetMapping("/rooms")
    @ResponseBody
    public List<Room> room() {
        return roomRepository.findAllRoom();
    }

    @PostMapping("/room")
    @ResponseBody
    public Room createRoom(@RequestParam String name) {
        return roomRepository.createChatRoom(name);
    }

    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "/chat/roomdetail";
    }

    @GetMapping("/room/{roomId}")
    @ResponseBody
    public Room roomInfo(@PathVariable String roomId) {
        return roomRepository.findRoomById(roomId);
    }
}
