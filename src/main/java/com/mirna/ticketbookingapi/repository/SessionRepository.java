package com.mirna.ticketbookingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mirna.ticketbookingapi.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
