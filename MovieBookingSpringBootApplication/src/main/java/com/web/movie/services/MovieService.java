package com.web.movie.services;

import java.util.List;

import com.web.movie.entities.Movie;

public interface MovieService {
	List<Movie> getAllMovies();
	List<Movie> findByTitle(String title);

}
