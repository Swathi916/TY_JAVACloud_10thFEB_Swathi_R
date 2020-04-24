package com.tyss.springboot.asg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.springboot.asg.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// that's it ... no need to write any code LOL!
	
}
