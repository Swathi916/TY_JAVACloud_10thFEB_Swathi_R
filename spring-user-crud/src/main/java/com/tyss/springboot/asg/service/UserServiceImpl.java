package com.tyss.springboot.asg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springboot.asg.dao.UserRepository;
import com.tyss.springboot.asg.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository studentRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository theStudentRepository) {
		studentRepository = theStudentRepository;
	}
	
	@Override
	public List<User> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public User findById(int theId) {
		Optional<User> result = studentRepository.findById(theId);
		
		User theStudent = null;
		
		if (result.isPresent()) {
			theStudent = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find  id - " + theId);
		}
		
		return theStudent;
	}

	@Override
	public void save(User theStudent) {
		studentRepository.save(theStudent);
	}

	@Override
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
	}

}






