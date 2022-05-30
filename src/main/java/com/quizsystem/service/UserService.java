package com.quizsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizsystem.model.User;
import com.quizsystem.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public User getUserByEmail(String email) {
		User user = new User();
		user = userRepository.getUserByEmail(email);
		return user;
	}
	
	public List<User> getAllUser(){
		List<User> users = new ArrayList<>();
		users = userRepository.findAll();
		return users;
	}
	
	public User getUserById(int id) {
		User user = new User();
		user = userRepository.getById(id);
		return user;
	}
	
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}
}
