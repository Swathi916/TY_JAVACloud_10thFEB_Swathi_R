package com.tyss.springboot.asg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springboot.asg.dao.StudentRepository;
import com.tyss.springboot.asg.entity.student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository theStudentRepository) {
		studentRepository = theStudentRepository;
	}
	
	@Override
	public List<student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public student findById(int theId) {
		Optional<student> result = studentRepository.findById(theId);
		
		student theStudent = null;
		
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
	public void save(student theStudent) {
		studentRepository.save(theStudent);
	}

	@Override
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
	}

}






