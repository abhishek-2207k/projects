package com.web.movie.services;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.movie.entities.Bookings;
import com.web.movie.repository.BookingsRepo;
@Service
@Transactional
public class BookingsServiceImpl implements BookingsService {
	@Autowired
	private BookingsRepo bookingsrepo;
	
	@Override
	@Transactional(dontRollbackOn= {NullPointerException.class,BrokenBarrierException.class})
	public void saveBookings(Bookings bookings) {
		// TODO Auto-generated method stub
		this.bookingsrepo.save(bookings);
		
	}

	@Override
	@Transactional(dontRollbackOn= {NullPointerException.class,BrokenBarrierException.class})
	public void deleteByTitle(String title) {
		
		((BookingsServiceImpl) this.bookingsrepo).deleteByTitle(title);
		
	}
	

	@Override
	@Transactional(dontRollbackOn= {NullPointerException.class,BrokenBarrierException.class})
	public List<Bookings> getAllBookings() {
		// TODO Auto-generated method stub
		return bookingsrepo.findAll();
	}

	@Override
	@Transactional(dontRollbackOn= {NullPointerException.class,BrokenBarrierException.class})
	public void deleteBookingsByTitle(String title) {
		// TODO Auto-generated method stub
		this.bookingsrepo.deleteByTitle(title);
		
	}

}
