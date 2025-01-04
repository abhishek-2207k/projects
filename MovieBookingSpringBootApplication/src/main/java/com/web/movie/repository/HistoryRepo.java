package com.web.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.movie.entities.History;


public interface HistoryRepo extends JpaRepository<History,Integer> {

}
