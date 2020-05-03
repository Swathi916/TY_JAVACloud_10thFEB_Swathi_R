package com.tyss.springboot.asg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springboot.asg.dao.RegisterRepository;
import com.tyss.springboot.asg.dao.ProductRepository;
import com.tyss.springboot.asg.entity.Product;
import com.tyss.springboot.asg.entity.Register;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(int theId) {
		Optional<Product> result = productRepository.findById(theId);
		
		Product theProduct = null;
		
		if (result.isPresent()) {
			theProduct = result.get();
		}
		else {
			throw new RuntimeException("Did not find  id - " + theId);
		}
		
		return theProduct;
	}

	@Override
	public void save(Product theProduct) {
		productRepository.save(theProduct);
	}

	@Override
	public void deleteById(int theId) {
		productRepository.deleteById(theId);
	}

	@Override
	public Register getByEmail(String email,String password) {
		return registerRepository.findByEmail(email, password);
	}

	@Override
	public Boolean saveUser(Register register) {
		Optional<Register> optional = registerRepository.findById(register.getEmail());
		if(optional.isPresent()) {
			return false;
		}
		else {
	         registerRepository.save(register);
	         return true;
		}
	}

	
}






