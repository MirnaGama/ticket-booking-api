package com.mirna.ticketbookingapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirna.ticketbookingapi.exception.NoSeatsAvailableException;
import com.mirna.ticketbookingapi.exception.NumberOfSeatsNotAvailableException;
import com.mirna.ticketbookingapi.model.Booking;
import com.mirna.ticketbookingapi.model.Session;
import com.mirna.ticketbookingapi.model.dto.BookingDTO;
import com.mirna.ticketbookingapi.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public Booking addBooking(@RequestBody BookingDTO bookingDTO) {
		
		try {
			return bookingService.addBooking(bookingDTO);
		} catch (NumberOfSeatsNotAvailableException | NoSeatsAvailableException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
