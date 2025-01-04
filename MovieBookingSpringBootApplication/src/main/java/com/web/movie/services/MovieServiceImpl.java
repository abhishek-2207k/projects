package com.web.movie.services;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.web.movie.entities.Movie;
import com.web.movie.repository.MovieRepo;
@Service
public class MovieServiceImpl implements MovieService{
	private MovieRepo movierepo;

	@Override
	@Transactional(dontRollbackOn= {NullPointerException.class,BrokenBarrierException.class})
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movierepo.findAll();
	}

	public MovieServiceImpl(MovieRepo movierepo) {
		super();
		this.movierepo = movierepo;
	}

	@Override
	@Transactional(dontRollbackOn= {NullPointerException.class,BrokenBarrierException.class})
	public List<Movie> findByTitle(String title) {
		// TODO Auto-generated method stub
		return movierepo.findByTitle(title);
	}

}
