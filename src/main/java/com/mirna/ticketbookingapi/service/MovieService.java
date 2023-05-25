package com.mirna.ticketbookingapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirna.ticketbookingapi.model.Movie;
import com.mirna.ticketbookingapi.repository.MovieRepository;


@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public Movie fetchMovie(Long id) {
		Optional<Movie> movie = movieRepository.findById(id);
		
		if (movie.isPresent()) {
			return movie.get();
		}
		
		return null;
	}

	public Movie addMovie(Movie movie) {
	
		return movieRepository.save(movie);
	}

	public Movie updateMovie(Long id, Movie movie) {
		if (movie.getId() != id) {
			return null;
		}
		
		Optional<Movie> oldMovie = movieRepository.findById(id);
		
		if (oldMovie.isPresent()) {
			return movieRepository.save(movie);
		}
		
		return null;
	}

	
	public void deleteMovie(Movie movie) {
		movieRepository.delete(movie);
	}

	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

}
