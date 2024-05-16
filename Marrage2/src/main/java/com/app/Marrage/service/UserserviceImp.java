package com.app.Marrage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Marrage.model.User;
import com.app.Marrage.repository.Userrepository;

@Service
public class UserserviceImp implements UserServiceInterface {
	
	@Autowired
	Userrepository userrepository;

	@Override
	public void addUser(User user) {
	    
		userrepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userrepository.findAll();
	}

	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return userrepository.findById(id).orElse(null);
	}

	@Override
	public List<User> getByPartialName(String name) {
		// TODO Auto-generated method stub
		return userrepository.findByPartialName(name);
	}

	@Override
	public List<User> getByGender(String gender) {
		
		
		return userrepository.findByGender(gender);
	}

	@Override
	public List<User> getUsersByAgeRange(int startAge, int endAge) {
		// TODO Auto-generated method stub
		return userrepository.findByAgeBetween(startAge, endAge);
	}

	@Override
	public List<User> getUserByIncomeRange(Long startIncome, Long endIncome) {
		
		return userrepository.findByIncomeBetween(startIncome,endIncome);
	}


	@Override
	public List<User> getByCaste(String caste) {
		
		return userrepository.findByCaste(caste);
	}

	@Override
	public List<User> getByReligion(String religion) {
		// TODO Auto-generated method stub
		return userrepository.findByReligion(religion);
	}

	@Override
	public List<User> getByOccupation(String occupation) {
		// TODO Auto-generated method stub
		return userrepository.findByOccupation(occupation);
	}
	



}
