package com.mirna.ticketbookingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirna.ticketbookingapi.model.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
