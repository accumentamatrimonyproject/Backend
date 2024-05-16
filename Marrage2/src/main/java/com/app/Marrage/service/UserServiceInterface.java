package com.app.Marrage.service;

import java.util.List;

import com.app.Marrage.model.User;


public interface UserServiceInterface {

	void addUser(User user);

	List<User> getAllUsers();

	User getById(Long id);

	List<User> getByPartialName(String name);

	List<User> getByGender(String gender);

	List<User> getUsersByAgeRange(int startAge, int endAge);

	List<User> getUserByIncomeRange(Long startIncome, Long endIncome);

	List<User> getByCaste(String caste);

	List<User> getByReligion(String religion);

	List<User> getByOccupation(String occupation);
	
	
	
	
	
	

}
