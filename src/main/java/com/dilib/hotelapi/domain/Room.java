package com.dilib.hotelapi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Room {

    @Id
    private Integer id;
    private RoomType type;
    private Integer price;

    public Room() {
    }

    public Room(Integer id, RoomType type, Integer price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public RoomType getType() {
        return type;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type=" + type +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) &&
                type == room.type &&
                Objects.equals(price, room.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, price);
    }
}
