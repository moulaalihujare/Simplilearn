package com.sportyshoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.entities.User;
import com.sportyshoes.repo.UserRepository;
import com.sportyshoes.response.UserResponse;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers()
	{
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public UserResponse searchUser(int id)
	{
		UserResponse ur = new UserResponse();
		Optional<User> searchedUser = userRepository.findById(id);
		if(searchedUser.isPresent())
		{
			User us = searchedUser.get();
			ur.setId(us.getId());
			ur.setContact(us.getContact());
			ur.setEmail(us.getEmail());
			ur.setName(us.getName());
			ur.setPassword(us.getPassword());
		}
		return ur;
	}
	
	public void deleteUser(int id)
	{
		userRepository.deleteById(id);
	}
	
	public User addUser(User person) {
		return userRepository.save(person);
	}

}
