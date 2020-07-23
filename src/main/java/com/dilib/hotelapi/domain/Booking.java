package com.dilib.hotelapi.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer roomId;
    private String username;
    private Integer numberOfNights;

    public Booking() {
    }

    public Booking(Integer roomId, String username, Integer numberOfNights) {
        this.roomId = roomId;
        this.username = username;
        this.numberOfNights = numberOfNights;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public String getUsername() {
        return username;
    }

    public Integer getNumberOfNights() {
        return numberOfNights;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", room_id=" + roomId +
                ", user_id=" + username +
                ", numberOfNights=" + numberOfNights +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) &&
                Objects.equals(roomId, booking.roomId) &&
                Objects.equals(username, booking.username) &&
                Objects.equals(numberOfNights, booking.numberOfNights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomId, username, numberOfNights);
    }
}
