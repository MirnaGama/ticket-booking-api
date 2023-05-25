package com.mirna.ticketbookingapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mirna.ticketbookingapi.model.User;
import com.mirna.ticketbookingapi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
    private UserService userService;

	@GetMapping()
    public List<User> getUsers() {
        List<User> response = userService.findAll();

        return response;
    }

	@GetMapping("{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.fetchUser(id);
    }

	@PostMapping()
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}
