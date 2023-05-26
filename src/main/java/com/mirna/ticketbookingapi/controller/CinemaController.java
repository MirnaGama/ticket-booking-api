package com.mirna.ticketbookingapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirna.ticketbookingapi.model.Cinema;
import com.mirna.ticketbookingapi.model.CinemaRoom;
import com.mirna.ticketbookingapi.model.Session;
import com.mirna.ticketbookingapi.service.CinemaService;

@RestController
@RequestMapping("cinema")
public class CinemaController {

	@Autowired
    private CinemaService cinemaService;
	
	@PostMapping()
    public Cinema addCinema(@RequestBody Cinema cinema) {
		return cinemaService.addCinema(cinema);
    }
	
	@PostMapping("room")
    public CinemaRoom addCinemaRoom(@RequestBody CinemaRoom cinemaRoom) {
		return cinemaService.addCinemaRoom(cinemaRoom);
    }

}
