package com.mirna.ticketbookingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mirna.ticketbookingapi.model.SessionSeat;

public interface SessionSeatRepository  extends JpaRepository<SessionSeat, Long> {
}

