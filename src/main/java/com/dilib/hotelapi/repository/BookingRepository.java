package com.dilib.hotelapi.repository;

import com.dilib.hotelapi.domain.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
}
