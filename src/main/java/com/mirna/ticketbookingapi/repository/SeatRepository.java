package com.mirna.ticketbookingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirna.ticketbookingapi.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}
