package com.mirna.ticketbookingapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirna.ticketbookingapi.constant.Status;
import com.mirna.ticketbookingapi.exception.NoSeatsAvailableException;
import com.mirna.ticketbookingapi.exception.NumberOfSeatsNotAvailableException;
import com.mirna.ticketbookingapi.model.Booking;
import com.mirna.ticketbookingapi.model.Session;
import com.mirna.ticketbookingapi.model.SessionSeat;
import com.mirna.ticketbookingapi.model.dto.BookingDTO;
import com.mirna.ticketbookingapi.repository.BookingRepository;
import com.mirna.ticketbookingapi.repository.SeatRepository;
import com.mirna.ticketbookingapi.repository.SessionRepository;
import com.mirna.ticketbookingapi.repository.SessionSeatRepository;


@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private SessionService sessionService;
	
	public Booking fetchBooking(Long id) {
		Optional<Booking> booking = bookingRepository.findById(id);
		
		if (booking.isPresent()) {
			return booking.get();
		}
		
		return null;
	}

	public Booking addBooking(BookingDTO bookingDTO) throws NumberOfSeatsNotAvailableException, NoSeatsAvailableException {
		
		List<SessionSeat> availableSeats = sessionService.getAvailableSessionSeats(bookingDTO.getSession());
		
		if (availableSeats.isEmpty()) {
			throw new NoSeatsAvailableException();
		}
		
		if (availableSeats.size() < bookingDTO.getNumberOfSeats()) {
			throw new NumberOfSeatsNotAvailableException();
		}
			
		Booking booking = new Booking();
		booking.setUser(bookingDTO.getUser());
		booking.setNumberOfSeats(bookingDTO.getNumberOfSeats());
		booking.setSession(bookingDTO.getSession());
		booking.setStatus("PENDING");
		
		_reserveSessionSeats(availableSeats, booking);
		
		return bookingRepository.save(booking);
	}

	public Booking updateBooking(Long id, Booking booking) {
		if (booking.getId() != id) {
			return null;
		}
		
		Optional<Booking> oldBooking = bookingRepository.findById(id);
		
		if (oldBooking.isPresent()) {
			return bookingRepository.save(booking);
		}
		
		return null;
	}

	
	public void deleteBooking(Booking booking) {
		bookingRepository.delete(booking);
	}

	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}
	
	public List<Booking> findUserBookings(Long userId) {
		return this.bookingRepository.findByUserId(userId);
	}
	
	private List<SessionSeat> _reserveSessionSeats(List<SessionSeat> availableSeats, Booking booking) {
		List<SessionSeat> reservedSeats = new ArrayList<SessionSeat>();
		
		for (SessionSeat seat : availableSeats.subList(0, booking.getNumberOfSeats())) {
			
			SessionSeat reservedSeat = seat;
			
			reservedSeat.setStatus(Status.RESERVED);
			reservedSeat.setBooking(booking);
			
			reservedSeats.add(reservedSeat);
		}
		
		if (reservedSeats.size() > 0) {
			return sessionService.updateSessionSeats(reservedSeats);
		}
		
		return null;
	}

}
