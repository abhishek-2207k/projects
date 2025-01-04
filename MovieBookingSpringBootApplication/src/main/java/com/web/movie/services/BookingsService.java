package com.web.movie.services;

import java.util.List;

import com.web.movie.entities.Bookings;
public interface BookingsService {
	List<Bookings> getAllBookings();
	void saveBookings(Bookings bookings);
	void deleteByTitle(String title);
	void deleteBookingsByTitle(String title);

}
