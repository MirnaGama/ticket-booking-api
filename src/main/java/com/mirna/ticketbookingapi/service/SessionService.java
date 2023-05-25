package com.mirna.ticketbookingapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirna.ticketbookingapi.model.Session;
import com.mirna.ticketbookingapi.repository.SessionRepository;

@Service
public class SessionService {

	@Autowired
	private SessionRepository sessionRepository;
	
	public Session fetchSession(Long id) {
		Optional<Session> session = sessionRepository.findById(id);
		
		if (session.isPresent()) {
			return session.get();
		}
		
		return null;
	}

	public Session addSession(Session session) {
	
		return sessionRepository.save(session);
	}

	public Session updateSession(Long id, Session booking) {
		if (booking.getId() != id) {
			return null;
		}
		
		Optional<Session> oldSession = sessionRepository.findById(id);
		
		if (oldSession.isPresent()) {
			return sessionRepository.save(booking);
		}
		
		return null;
	}

	
	public void deleteSession(Session booking) {
		sessionRepository.delete(booking);
	}

	public List<Session> findAll() {
		return sessionRepository.findAll();
	}
}
