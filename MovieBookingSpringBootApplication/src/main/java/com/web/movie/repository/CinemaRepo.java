package com.web.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.movie.entities.Cinema;

@Repository
public interface CinemaRepo extends JpaRepository<Cinema,Integer> {

}
