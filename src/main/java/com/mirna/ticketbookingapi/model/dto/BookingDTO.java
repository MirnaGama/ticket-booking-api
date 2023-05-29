package com.mirna.ticketbookingapi.model.dto;

import com.mirna.ticketbookingapi.model.CinemaRoom;
import com.mirna.ticketbookingapi.model.Movie;
import com.mirna.ticketbookingapi.model.Session;
import com.mirna.ticketbookingapi.model.User;

public class BookingDTO {

	private User user;
	private Movie movie;
	private CinemaRoom cinemaRoom;
	private int numberOfSeats;
	private Session session;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public CinemaRoom getCinemaRoom() {
		return cinemaRoom;
	}
	public void setCinemaRoom(CinemaRoom cinemaRoom) {
		this.cinemaRoom = cinemaRoom;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	
	
}
