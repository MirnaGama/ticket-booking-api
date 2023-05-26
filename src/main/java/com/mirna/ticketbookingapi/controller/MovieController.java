package com.mirna.ticketbookingapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mirna.ticketbookingapi.model.Movie;
import com.mirna.ticketbookingapi.model.Session;
import com.mirna.ticketbookingapi.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping()
    public List<Movie> getMovies() {

		List<Movie> response = movieService.findAll();
        return response;
    }
	
	@GetMapping("sessions/{id}")
    public List<Session> getMovieSessions(@RequestParam Long id) {

		Movie movie = movieService.fetchMovie(id);
        return movie.getSessions();
    }
	
	@PostMapping()
    public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
    }
}
