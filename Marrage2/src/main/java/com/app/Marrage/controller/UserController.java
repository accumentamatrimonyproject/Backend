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
import com.app.Marrage.service.UserServiceInterface;
import com.app.Marrage.service.UserserviceImp;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class UserController {
	
	
	@Autowired
	UserServiceInterface userservice;
	
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
		System.out.println("frpm front end");
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
	 
	 
	  //search by age
	  @GetMapping("/filterByAgeRange/{startAge}-{endAge}")
	    public ResponseEntity<List<User>> filterByAgeRange(@PathVariable int startAge, @PathVariable int endAge) {
	        List<User> users = userservice.getUsersByAgeRange(startAge, endAge);
	        if (!users.isEmpty()) {
	            return ResponseEntity.ok(users);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	  
	  
	  
	  @GetMapping("/filterByIncome/{startIncome}-{endIncome}")
	  public ResponseEntity<List<User>> filterByIncome(@PathVariable Long startIncome,@PathVariable Long endIncome)
	  {
		  List<User> users = userservice.getUserByIncomeRange(startIncome,endIncome);
		  
		  if(!users.isEmpty())
		  {
			  return ResponseEntity.ok(users);
		  }
		  else
		  {
			  return ResponseEntity.notFound().build();
		  }
	  }
	  
	  
		 @GetMapping("/searchByCaste/{caste}")
		 public ResponseEntity<List<User>> searchByCaste(@PathVariable String caste)
		 {
			 List<User> users = userservice.getByCaste(caste);
			 
			 if(!users.isEmpty())
			 {
				 return ResponseEntity.ok(users);
			 }
			 else
			 {
				 return ResponseEntity.notFound().build();
			 }
			 
		 }
		 
		 
		 @GetMapping("/searchByReligion/{religion}")
		 public ResponseEntity<List<User>> searchByReligion(@PathVariable String religion)
		 {
			 List<User> users = userservice.getByReligion(religion);
			 
			 if(!users.isEmpty())
			 {
				 return ResponseEntity.ok(users);
			 }
			 else
			 {
				 return ResponseEntity.notFound().build();
			 }
					
		 }
		 
		 
		 @GetMapping("/searchByOccupation/{occupation}")
		 public ResponseEntity<List<User>> searchByoccupation(@PathVariable String occupation)
		 {
			 List<User> users = userservice.getByOccupation(occupation);
			 
			 if(!users.isEmpty())
			 {
				 return ResponseEntity.ok(users);
			 }
			 else
			 {
				 return ResponseEntity.notFound().build();
			 }
					
		 }
		 
		 
	 
	 
	 
	 
	 
	 
	 
	

}
