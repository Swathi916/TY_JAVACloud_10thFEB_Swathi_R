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

import com.tyss.springboot.asg.entity.student;
import com.tyss.springboot.asg.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private StudentService studentService;
	
	@Autowired
	public StudentRestController(StudentService theStudentService) {
		studentService = theStudentService;
	}
	
	
	@GetMapping("/students")
	public List<student> findAll() {
		return studentService.findAll();
	}

	
	
	@GetMapping("/students/{studentId}")
	public student getEmployee(@PathVariable int studentId) {
		
		student theStudent = studentService.findById(studentId);
		
		if (theStudent == null) {
			throw new RuntimeException("student id not found - " + studentId);
		}
		
		return theStudent;
	}
	
	
	@PostMapping("/students")
	public student addStudent(@RequestBody student theStudent) {
		
		theStudent.setId(0);
		
		studentService.save(theStudent);
		
		return theStudent;
	}
	
	
	
	@PutMapping("/students")
	public student updateStudent(@RequestBody student theStudent) {
		
		studentService.save(theStudent);
		
		return theStudent;
	}
	
	
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		
		student tempStudent = studentService.findById(studentId);
		
		
		
		if (tempStudent == null) {
			throw new RuntimeException("Student id not found - " + studentId);
		}
		
		studentService.deleteById(studentId);
		
		return "Deleted student id - " + studentId;
	}
	
}










