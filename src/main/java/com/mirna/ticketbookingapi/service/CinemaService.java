package com.mirna.ticketbookingapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirna.ticketbookingapi.model.Cinema;
import com.mirna.ticketbookingapi.model.CinemaRoom;
import com.mirna.ticketbookingapi.model.Seat;
import com.mirna.ticketbookingapi.repository.CinemaRepository;
import com.mirna.ticketbookingapi.repository.CinemaRoomRepository;
import com.mirna.ticketbookingapi.repository.SeatRepository;

@Service
public class CinemaService {

	@Autowired
	private CinemaRepository cinemaRepository;
	
	@Autowired
	private CinemaRoomRepository cinemaRoomRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	
	public Cinema addCinema(Cinema cinema) {
		return cinemaRepository.save(cinema);
	}
	
	public CinemaRoom addCinemaRoom(CinemaRoom cinemaRoom) {
		
		CinemaRoom cinemaRoomAdded = cinemaRoomRepository.save(cinemaRoom);
		
		if (cinemaRoomAdded != null) {
			_createCinemaRoomSeats(cinemaRoomAdded);
		}
		
		return cinemaRoomAdded;
	}
	
	private List<Seat> _createCinemaRoomSeats(CinemaRoom cinemaRoom) {
		int numberOfSeats = cinemaRoom.getTotalSeats();
		
		List<Seat> cinemaRoomSeats = new ArrayList<Seat>();
		// CREATING THE SEATS FROM THE CINEMA ROOM AUTOMATICALLY...
		for (int i = 0; i < numberOfSeats; i++) {
			Seat seat = new Seat();
			
			seat.setSeatNumber(i+1);
			seat.setCinemaRoom(cinemaRoom);
			
			cinemaRoomSeats.add(seat);
		}
		
		if (cinemaRoomSeats.size() > 0) {
			return seatRepository.saveAll(cinemaRoomSeats);
		}
		
		return null;
	}
	
}
