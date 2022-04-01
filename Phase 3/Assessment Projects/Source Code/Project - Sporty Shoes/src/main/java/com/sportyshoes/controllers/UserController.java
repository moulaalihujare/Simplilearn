package com.sportyshoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entities.User;
import com.sportyshoes.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<User> getUsers()
	{
		List<User> users = userService.getAllUsers();
		return users;
	}
	
	@GetMapping("/{userId}")
	public String getUser(@PathVariable int userId)
	{
		if(userService.searchUser(userId).getId()==0)
		{
			return "User not Available";
		}
		else
		{
			return userService.searchUser(userId).toString();
		}
	}
	
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable int userId)
	{
		userService.deleteUser(userId);
		return "User Deleted";
	}
	
	@PostMapping("/")
	public ResponseEntity<User> addPerson(@RequestBody User user)
	{
		User obj= userService.addUser(user);
		return new ResponseEntity<User>(obj,HttpStatus.CREATED);
	}
	
}
