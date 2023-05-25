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

@Entity(name="CINEMA")
public class Cinema {

	@Id
	@Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(mappedBy="cinema")
	private List<CinemaRoom> cinemaRooms;
	
	@OneToOne
	@JoinColumn(name="CITY_ID")
	private City city;

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

	public List<CinemaRoom> getCinemaRooms() {
		return cinemaRooms;
	}

	public void setCinemaRooms(List<CinemaRoom> cinemaRooms) {
		this.cinemaRooms = cinemaRooms;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
}
