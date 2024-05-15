package com.app.Marrage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.Marrage.model.User;

@Repository
public interface Userrepository extends JpaRepository<User, Long> {
	
	
	 @Query("SELECT u FROM User u WHERE u.fullName LIKE %:name%")
	    List<User> findByPartialName(@Param("name") String name);

	  List<User> findByGender(String gender);

}
