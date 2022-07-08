package com.example.websocketchat.repository;

import com.example.websocketchat.dto.Room;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class RoomRepository {

    private Map<String, Room> chatRoomMap;
    @PostConstruct
    private void init() {
        chatRoomMap = new LinkedHashMap<>();
    }
    public List<Room> findAllRoom() {
        // 채팅방 생성순서 최근 순으로 반환
        List chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }
    public Room findRoomById(String id) {
        return chatRoomMap.get(id);
    }
    public Room createChatRoom(String name) {
        Room chatRoom = Room.create(name);
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }

}
