package com.web.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.movie.entities.Screen;

@Repository
public interface ScreenRepo extends JpaRepository<Screen,Integer>{

}
