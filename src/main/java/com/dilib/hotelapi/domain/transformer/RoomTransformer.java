package com.dilib.hotelapi.domain.transformer;

import com.dilib.hotelapi.domain.Room;
import com.dilib.hotelapi.domain.dto.RoomDto;

public class RoomTransformer {

    public static Room transform(RoomDto roomDto) {
        return new Room(roomDto.getId(), roomDto.getType(), roomDto.getPrice());
    }

    public static RoomDto transform(Room room) {
        return new RoomDto(room.getId(), room.getType(), room.getPrice());
    }
}
