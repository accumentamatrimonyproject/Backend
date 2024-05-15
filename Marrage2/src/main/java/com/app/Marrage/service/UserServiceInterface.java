package com.app.Marrage.service;

import java.util.List;

import com.app.Marrage.model.User;


public interface UserServiceInterface {

	void addUser(User user);

	List<User> getAllUsers();

	User getById(Long id);

	List<User> getByPartialName(String name);

	List<User> getByGender(String gender);
	
	
	
	
	
	

}
