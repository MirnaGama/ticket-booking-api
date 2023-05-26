package com.mirna.ticketbookingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirna.ticketbookingapi.model.CinemaRoom;

public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Long> {

}
