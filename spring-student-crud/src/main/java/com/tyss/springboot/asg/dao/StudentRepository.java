package com.tyss.springboot.asg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.springboot.asg.entity.student;

public interface StudentRepository extends JpaRepository<student, Integer> {

	// that's it ... no need to write any code LOL!
	
}
