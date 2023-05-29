package com.mirna.ticketbookingapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirna.ticketbookingapi.constant.Status;
import com.mirna.ticketbookingapi.model.CinemaRoom;
import com.mirna.ticketbookingapi.model.Seat;
import com.mirna.ticketbookingapi.model.Session;
import com.mirna.ticketbookingapi.model.SessionSeat;
import com.mirna.ticketbookingapi.repository.SessionRepository;
import com.mirna.ticketbookingapi.repository.SessionSeatRepository;

@Service
public class SessionService {

	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private SessionSeatRepository sessionSeatRepository;
	
	public Session fetchSession(Long id) {
		Optional<Session> session = sessionRepository.findById(id);
		
		if (session.isPresent()) {
			return session.get();
		}
		
		return null;
	}

	public Session addSession(Session session) {

		Session sessionAdded = sessionRepository.save(session);
		
		if (sessionAdded != null) {
			_createSessionSeats(sessionAdded);
		}
		
		return sessionAdded;
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
	
	private List<SessionSeat> _createSessionSeats(Session session) {
		List<Seat> seats = session.getCinemaRoom().getSeats();
		
		List<SessionSeat> sessionSeats = new ArrayList<SessionSeat>();
		// CREATING THE SEATS FROM THE SESSION AUTOMATICALLY...
		for (Seat seat: seats) {
			SessionSeat sessionSeat = new SessionSeat();
			
			sessionSeat.setSeat(seat);
			sessionSeat.setSession(session);
			sessionSeat.setStatus(Status.AVAILABLE); 
			
			sessionSeats.add(sessionSeat);
		}
		
		if (sessionSeats.size() > 0) {
			return sessionSeatRepository.saveAll(sessionSeats);
		}
		
		return null;
	}
	
	public List<SessionSeat> getAvailableSessionSeats(Session session) {
		List<SessionSeat> seats = session.getSeats();
	
	    return seats.stream()
	    	    .filter(s -> s.getStatus()
	    	    		.equalsIgnoreCase(Status.AVAILABLE))
	    	    		.collect(Collectors.toList());
	}
	
	public List<SessionSeat> updateSessionSeats(List<SessionSeat> sessionSeats) {
		return sessionSeatRepository.saveAll(sessionSeats);
	}
	
}
