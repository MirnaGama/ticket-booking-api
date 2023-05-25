package com.mirna.ticketbookingapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="SEAT")
public class Seat {

	@Id
	@Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="SEAT_NUMBER")
	private int seatNumber;
	
	@OneToOne
	@JoinColumn(name="SESSION_ID")
	private Session session;
	
	@Column(name="STATUS")
	private int status;
	
	@Column(name="PRICE")
	private float price;
	
	@OneToOne
	@JoinColumn(name="BOOKING_ID")
	private Booking booking;
	
	@OneToOne
	@JoinColumn(name="CINEMA_ROOM_ID")
	private CinemaRoom cinemaRoom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
