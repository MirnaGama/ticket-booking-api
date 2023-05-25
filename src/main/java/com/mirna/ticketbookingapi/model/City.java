package com.mirna.ticketbookingapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="CITY")
public class City {

	@Id
	@Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIP_CODE")
	private String zipCode;
}
