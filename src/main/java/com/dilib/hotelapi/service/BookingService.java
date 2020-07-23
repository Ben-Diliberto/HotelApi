package com.dilib.hotelapi.service;

import com.dilib.hotelapi.domain.Booking;
import com.dilib.hotelapi.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final RoomService roomService;

    public BookingService(BookingRepository bookingRepository, UserService userService, RoomService roomService) {
        this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.roomService = roomService;
    }

    public Collection<Booking> getAllBookings() {
        return (ArrayList<Booking>) bookingRepository.findAll();
    }

    public void addBooking(Booking booking) {
        if (roomService.exists(booking.getRoomId()) && userService.exists(booking.getUsername())) {
            bookingRepository.save(new Booking(booking.getRoomId(), booking.getUsername(), booking.getNumberOfNights()));
        }
    }

    public Booking getBookingById(Integer id) {
        return bookingRepository.findById(id).orElseThrow();
    }
}
