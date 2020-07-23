package com.dilib.hotelapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BookingDto {

    private Integer id;
    private Integer roomId;
    private String userId;
    private Integer numberOfNights;

    @JsonCreator
    public BookingDto(@JsonProperty("roomId") Integer roomId,
                      @JsonProperty("userId") String userId,
                      @JsonProperty("numberOfNights") Integer numberOfNights) {
        this.roomId = roomId;
        this.userId = userId;
        this.numberOfNights = numberOfNights;
    }

    public BookingDto(Integer id, Integer roomId, String userId, Integer numberOfNights) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.numberOfNights = numberOfNights;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "id=" + id +
                ", room_id=" + roomId +
                ", user_id='" + userId + '\'' +
                ", numberOfNights=" + numberOfNights +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingDto that = (BookingDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(roomId, that.roomId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(numberOfNights, that.numberOfNights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomId, userId, numberOfNights);
    }
}
