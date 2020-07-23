package com.dilib.hotelapi.domain.dto;

import com.dilib.hotelapi.domain.RoomType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class RoomDto {

    private Integer id;
    private RoomType type;
    private Integer price;

    @JsonCreator
    public RoomDto(@JsonProperty("id") Integer id,
                   @JsonProperty("type") RoomType type,
                   @JsonProperty("price") Integer price) {
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
        return "RoomDto{" +
                "id=" + id +
                ", type=" + type +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDto roomDto = (RoomDto) o;
        return Objects.equals(id, roomDto.id) &&
                type == roomDto.type &&
                Objects.equals(price, roomDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, price);
    }
}
