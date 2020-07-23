package com.dilib.hotelapi.controller;

import com.dilib.hotelapi.domain.RoomType;
import com.dilib.hotelapi.domain.dto.RoomDto;
import com.dilib.hotelapi.domain.transformer.RoomTransformer;
import com.dilib.hotelapi.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<Collection<RoomDto>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms().stream().map(RoomTransformer::transform).collect(Collectors.toList()));
    }

    @PostMapping
    public void addRoom(@RequestBody RoomDto roomDto) {
        roomService.addRoom(RoomTransformer.transform(roomDto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(RoomTransformer.transform(roomService.getRoomById(id)));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRoomById(@PathVariable(value = "id") Integer id) {
        roomService.deleteRoom(id);
    }

    @GetMapping(value = "/type/{type}")
    public ResponseEntity<Collection<RoomDto>> getRoomsOfType(@PathVariable(value = "type") RoomType roomType) {
        return ResponseEntity.ok(roomService.getRoomsOfType(roomType).stream().map(RoomTransformer::transform).collect(Collectors.toList()));
    }
}
