package com.app.Marrage.repository;

import java.util.List;
import java.util.Optional;

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

	  List<User> findByAgeBetween(int startAge, int endAge);

	  List<User> findByIncomeBetween(Long startIncome, Long endIncome);

	  List<User> findByCaste(String caste);

	List<User> findByReligion(String religion);
    
	@Query("SELECT u FROM User u WHERE u.occupation LIKE %:occupation%")
	List<User> findByOccupation( @Param("occupation")String occupation);

	List<User> findByHeight(double height);
	
	 Optional<User> findByName(String userName);

	 @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
	User findByUserName( @Param("name")String name);
	  
	  

}
