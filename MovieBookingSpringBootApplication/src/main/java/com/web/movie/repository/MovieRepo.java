package com.web.movie.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.movie.entities.Movie;

@Transactional
@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer>{

	List<Movie> findByTitle(String title);
	
	@Modifying 
	@Query(value="update movie set seats=:seat where title=:name",nativeQuery = true)
	public void editSeats(@Param("seat") int seats,@Param("name") String title);
	
	@Query(value="select seats from movie where title=:title",nativeQuery=true)
	public int getSeats(@Param("title") String title);

}
