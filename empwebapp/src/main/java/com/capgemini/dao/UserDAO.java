package com.capgemini.dao;

import java.util.List;

import com.capgemini.bean.User;

public interface UserDAO {

	List<User> get();
	
	boolean save(User e);
	
	User get(int id);
	
	boolean update(User e);
	
	boolean delete(int id);
}
