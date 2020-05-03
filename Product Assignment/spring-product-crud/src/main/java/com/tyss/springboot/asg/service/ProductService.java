package com.tyss.springboot.asg.service;

import java.util.List;

import com.tyss.springboot.asg.entity.Product;
import com.tyss.springboot.asg.entity.Register;

public interface ProductService {

	public List<Product> findAll();
	
	public Product findById(int theId);
	
	public Product save(Product theEmployee);
	
	public void deleteById(int theId);
	
	public  Register getByEmail(String email,String password);
	
	public Boolean saveUser(Register register);
	
	
	
}
