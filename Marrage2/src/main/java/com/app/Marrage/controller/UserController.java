package com.app.Marrage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Marrage.model.User;

import com.app.Marrage.service.UserserviceImp;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class UserController {
	
	
	@Autowired
	UserserviceImp userservice;
	
	@GetMapping("/test")
	public String test()
	{
		return "it's working";
	}
	
	
	@PostMapping("/register")
	public void addUser(@RequestBody User user)
	{
		String fName = user.getFirstName();
		String mName = user.getMiddleName();
		String lName = user.getLastName();
		user.setFullName(fName, mName, lName);
		userservice.addUser(user);
	}
	
	
	@GetMapping("/findAll")
	public List<User> getAllUsers()
	{
		List<User> users = userservice.getAllUsers();
		
		return users;
	}
	
	
	
	@GetMapping("/getById/{id}")
	public User getById(@PathVariable Long id)
	{
		User user = userservice.getById(id);
		
		return user;
	}
	
	 @GetMapping("/searchByName/{name}")
	    public ResponseEntity<List<User>> searchByName(@PathVariable String name) {
	        List<User> users = userservice.getByPartialName(name);
	        if (!users.isEmpty()) {
	            return ResponseEntity.ok(users);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
     
	 
	 @GetMapping("/searchByGender/{gender}")
	 public ResponseEntity<List<User>> searchByGender (@PathVariable String gender)
	 {
		 List<User> users = userservice.getByGender(gender);
		 
		  if (!users.isEmpty()) {
	            return ResponseEntity.ok(users);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
		 
	     
	 }
	 
	

}
