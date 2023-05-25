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

@Entity(name="BOOKING")
public class Booking {

	@Id
	@Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NUMBEROFSEATS")
	private int numberOfSeats;
	
	@Column(name="STATUS")
	private String status;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@OneToOne
	@JoinColumn(name="SESSION_ID")
	private Session session;
	
	@OneToOne
	@JoinColumn(name="PAYMENT_ID")
	private Payment payment;
	
	@OneToMany(mappedBy="booking")
	private List<Seat> seats;

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setReservedSeats(List<Seat> seats) {
		this.seats = seats;
	}
}
