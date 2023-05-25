package com.mirna.ticketbookingapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirna.ticketbookingapi.model.User;
import com.mirna.ticketbookingapi.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public User fetchUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		
		if (user.isPresent()) {
			return user.get();
		}
		
		return null;
	}

	public User addUser(User user) {
	
		return userRepository.save(user);
	}

	public User updateUser(Long id, User user) {
		if (user.getId() != id) {
			return null;
		}
		
		Optional<User> oldUser = userRepository.findById(id);
		
		if (oldUser.isPresent()) {
			return userRepository.save(user);
		}
		
		return null;
	}

	
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	
}
