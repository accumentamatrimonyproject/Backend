package com.app.Marrage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.Marrage.model.User;
import com.app.Marrage.repository.Userrepository;

@Service
public class UserInfoService implements UserServiceInterface, UserDetailsService {

    @Autowired
    Userrepository userrepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = userrepository.findByName(username);
        return userInfo.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userrepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userrepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userrepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getByPartialName(String name) {
        return userrepository.findByPartialName(name);
    }

    @Override
    public List<User> getByGender(String gender) {
        return userrepository.findByGender(gender);
    }

    @Override
    public List<User> getUsersByAgeRange(int startAge, int endAge) {
        return userrepository.findByAgeBetween(startAge, endAge);
    }

    @Override
    public List<User> getUserByIncomeRange(Long startIncome, Long endIncome) {
        return userrepository.findByIncomeBetween(startIncome, endIncome);
    }

    @Override
    public List<User> getByCaste(String caste) {
        return userrepository.findByCaste(caste);
    }

    @Override
    public List<User> getByReligion(String religion) {
        return userrepository.findByReligion(religion);
    }

    @Override
    public List<User> getByOccupation(String occupation) {
        return userrepository.findByOccupation(occupation);
    }

    @Override
    public List<User> getByHeight(double height) {
        return userrepository.findByHeight(height);
    }

	@Override
	public User getUserByUserName(String name) {
		// TODO Auto-generated method stub
		return userrepository.findByUserName(name);
	}
}
