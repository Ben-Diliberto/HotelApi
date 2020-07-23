package com.dilib.hotelapi.service;

import com.dilib.hotelapi.domain.Room;
import com.dilib.hotelapi.domain.RoomType;
import com.dilib.hotelapi.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Collection<Room> getAllRooms() {
        return (ArrayList<Room>) roomRepository.findAll();
    }

    public void addRoom(Room room) {
        roomRepository.save(room);
    }

    public Room getRoomById(Integer id) {
        return roomRepository.findById(id).orElseThrow();
    }

    public Collection<Room> getRoomsOfType(RoomType roomType) {
        Collection<Room> rooms = (ArrayList<Room>) roomRepository.findAll();
        return rooms.stream().filter(room -> room.getType() == roomType).collect(Collectors.toList());
    }

    public void deleteRoom(Integer id) {
        roomRepository.deleteById(id);
    }
}
