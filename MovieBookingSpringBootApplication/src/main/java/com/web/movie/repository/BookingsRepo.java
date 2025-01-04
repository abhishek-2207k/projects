package com.web.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.movie.entities.Bookings;
@Repository
public interface BookingsRepo extends JpaRepository<Bookings,Integer> {

	void deleteByTitle(String title);
	
	
	
	

	
}
