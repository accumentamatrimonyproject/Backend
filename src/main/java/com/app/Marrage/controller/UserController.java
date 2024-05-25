package com.app.Marrage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.app.Marrage.logout.BlackList;
import com.app.Marrage.model.AuthRequest;
import com.app.Marrage.model.User;
import com.app.Marrage.service.JwtService;
import com.app.Marrage.service.UserServiceInterface;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {

    @Autowired
    UserServiceInterface userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    BlackList blackList;

    @Autowired
    JwtService jwtService;
    
    //HRLLO

    @PostMapping("/logoutuser")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public String logout(HttpServletRequest request) 
    {
        System.out.println("in logout");
    	 String authHeader = request.getHeader("Authorization");
         if (authHeader != null && authHeader.startsWith("Bearer ")) {
             String token = authHeader.substring(7);
             blackList.blacKListToken(token);
         }
         return "You have successfully logged out !!";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String fName = user.getFirstName();
        String mName = user.getMiddleName();
        String lName = user.getLastName();
        user.setFullName(fName, mName, lName);
        userService.addUser(user);
        String token = jwtService.generateToken(user.getName());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUserName());
        } else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }
    
//    @PostMapping("/login")
//    public ResponseEntity<Void> loginUser(@RequestBody AuthRequest authRequest) {
//        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
//        if (authenticate.isAuthenticated()) {
//            String token = jwtService.generateToken(authRequest.getUserName());
//            return ResponseEntity.ok().header("Authorization", "Bearer " + token).build();
//        } else {
//            throw new UsernameNotFoundException("Invalid user request");
//        }
//    }


//    @PostMapping("/logout")
//    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
//    public String logoutUser(HttpServletRequest request) {
//        String authHeader = request.getHeader("Authorization");
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            String token = authHeader.substring(7);
//            blackList.blacKListToken(token);
//        }
//        return "You have successfully logged out !!";
//    }
//    
    
//    @GetMapping("/logout")
//    public String logout()
//    {
//    	System.out.println("logout");
//    	return "logout";
//    }

    @GetMapping("/findAll")
   // @PreAuthorize("hasAuthority('USER')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getById/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/searchByName/{name}")
    public ResponseEntity<List<User>> searchByName(@PathVariable String name) {
        List<User> users = userService.getByPartialName(name);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/searchByGender/{gender}")
    public ResponseEntity<List<User>> searchByGender(@PathVariable String gender) {
        List<User> users = userService.getByGender(gender);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filterByAgeRange/{startAge}-{endAge}")
    public ResponseEntity<List<User>> filterByAgeRange(@PathVariable int startAge, @PathVariable int endAge) {
        List<User> users = userService.getUsersByAgeRange(startAge, endAge);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filterByIncome/{startIncome}-{endIncome}")
    public ResponseEntity<List<User>> filterByIncome(@PathVariable Long startIncome, @PathVariable Long endIncome) {
        List<User> users = userService.getUserByIncomeRange(startIncome, endIncome);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/searchByCaste/{caste}")
    public ResponseEntity<List<User>> searchByCaste(@PathVariable String caste) {
        List<User> users = userService.getByCaste(caste);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/searchByReligion/{religion}")
    public ResponseEntity<List<User>> searchByReligion(@PathVariable String religion) {
        List<User> users = userService.getByReligion(religion);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/searchByOccupation/{occupation}")
    public ResponseEntity<List<User>> searchByOccupation(@PathVariable String occupation) {
        List<User> users = userService.getByOccupation(occupation);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/searchByHeight/{height}")
    public ResponseEntity<List<User>> searchByHeight(@PathVariable double height) {
        List<User> users = userService.getByHeight(height);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @GetMapping("/getByUserName/{name}")
    public User getByUserName(@PathVariable String name) {
        return userService.getUserByUserName(name);
    }
    
      
    
    
    
}
