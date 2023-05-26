package com.mirna.ticketbookingapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mirna.ticketbookingapi.model.Movie;
import com.mirna.ticketbookingapi.model.Session;
import com.mirna.ticketbookingapi.service.MovieService;
import com.mirna.ticketbookingapi.service.SessionService;

@RestController
@RequestMapping("/session")
public class SessionController {

		@Autowired
		private SessionService sessionService;
		
		@PostMapping()
	    public Session addSession(@RequestBody Session session) {
			return sessionService.addSession(session);
	    }
	}
