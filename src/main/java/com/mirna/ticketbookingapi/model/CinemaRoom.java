package com.mirna.ticketbookingapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="CINEMA_ROOM")
public class CinemaRoom {

	@Id
	@Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="TOTAL_SEATS")
	private int totalSeats;
	
	@OneToOne
	@JoinColumn(name="CINEMA_ID")
	private Cinema cinema;
	
	@OneToMany(mappedBy="cinemaRoom")
	private List<Session> sessions;
	
	@OneToMany(mappedBy="cinemaRoom")
	private List<Seat> seats;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	
	
}
