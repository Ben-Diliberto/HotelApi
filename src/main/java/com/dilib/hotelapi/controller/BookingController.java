package com.dilib.hotelapi.controller;

import com.dilib.hotelapi.domain.dto.BookingDto;
import com.dilib.hotelapi.domain.transformer.BookingTransformer;
import com.dilib.hotelapi.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<Collection<BookingDto>> getAllBookings() {
        return ResponseEntity.ok(BookingTransformer.transform(bookingService.getAllBookings()));
    }

    @PostMapping
    public void addBooking(@RequestBody BookingDto bookingDto) {
        bookingService.addBooking(BookingTransformer.transform(bookingDto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(BookingTransformer.transform(bookingService.getBookingById(id)));
    }
}
