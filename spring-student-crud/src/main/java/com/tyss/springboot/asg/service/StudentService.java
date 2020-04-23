package com.tyss.springboot.asg.service;

import java.util.List;

import com.tyss.springboot.asg.entity.student;

public interface StudentService {

	public List<student> findAll();
	
	public student findById(int theId);
	
	public void save(student theEmployee);
	
	public void deleteById(int theId);
	
}
