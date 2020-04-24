package com.tyss.springboot.asg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springboot.asg.entity.User;
import com.tyss.springboot.asg.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	private UserService userService;
	
	@Autowired
	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}
	
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}

	
	
	@GetMapping("/users/{userId}")
	public User getEmployee(@PathVariable int userId) {
		
		User theUser = userService.findById(userId);
		
		if (theUser == null) {
			throw new RuntimeException("user not found - " + userId);
		}
		
		return theUser;
	}
	
	
	@PostMapping("/users")
	public User addStudent(@RequestBody User theUser) {
		
		theUser.setId(0);
		
		userService.save(theUser);
		
		return theUser;
	}
	
	
	
	@PutMapping("/users")
	public User updateStudent(@RequestBody User theUser) {
		
		userService.save(theUser);
		
		return theUser;
	}
	
	
	
	@DeleteMapping("/users/{userId}")
	public String deleteStudent(@PathVariable int userId) {
		
		User tempUser = userService.findById(userId);
		
		
		
		if (tempUser == null) {
			throw new RuntimeException(" id not found - " + userId);
		}
		
		userService.deleteById(userId);
		
		return "Deleted  id - " + userId;
	}
	
}










