package com.dilib.hotelapi.domain.transformer;

import com.dilib.hotelapi.domain.Booking;
import com.dilib.hotelapi.domain.dto.BookingDto;

import java.util.Collection;
import java.util.stream.Collectors;

public class BookingTransformer {

    public static Booking transform(BookingDto bookingDto) {
        return new Booking(bookingDto.getRoomId(), bookingDto.getUserId(), bookingDto.getNumberOfNights());
    }

    public static BookingDto transform(Booking booking) {
        return new BookingDto(booking.getId(), booking.getRoomId(), booking.getUsername(), booking.getNumberOfNights());
    }

    public static Collection<BookingDto> transform(Collection<Booking> bookings) {
        return bookings.stream().map(BookingTransformer::transform).collect(Collectors.toList());
    }
}
