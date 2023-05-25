package com.mirna.ticketbookingapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirna.ticketbookingapi.model.Booking;
import com.mirna.ticketbookingapi.repository.BookingRepository;


@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public Booking fetchBooking(Long id) {
		Optional<Booking> booking = bookingRepository.findById(id);
		
		if (booking.isPresent()) {
			return booking.get();
		}
		
		return null;
	}

	public Booking addBooking(Booking booking) {
	
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

}
