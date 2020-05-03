package com.tyss.springboot.asg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tyss.springboot.asg.entity.Register;
public interface RegisterRepository extends JpaRepository<Register,String> {
     
	@Query("from Register where email=?1 and password=?2")
	Register findByEmail(String email ,String password);
}
