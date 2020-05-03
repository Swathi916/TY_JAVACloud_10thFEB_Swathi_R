package com.tyss.springboot.asg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springboot.asg.entity.Product;
import com.tyss.springboot.asg.entity.Register;
import com.tyss.springboot.asg.exception.ProductNotFoundException;
import com.tyss.springboot.asg.response.Response;
import com.tyss.springboot.asg.service.ProductService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class ProductRestController {

	private ProductService productService;

	
	
	@Autowired
	public ProductRestController(ProductService theProductService) {
		productService = theProductService;
	}
	
	
	@GetMapping("/products/get")
	public List<Product> findAll() {
		return productService.findAll();
	}

	
	@GetMapping("/products/{productId}")
	public Response<Product> getProducts(@PathVariable int productId) {
		
		Product theProduct = productService.findById(productId);
		
		if (theProduct!= null) {
			return new Response<>(false,"Records found",theProduct);
			
		}else {
			throw new ProductNotFoundException("Records not found ");
			
		}
		
	}
	
	
	@PostMapping("/products/post")
	public Response<Product> addProduct(@RequestBody Product theProduct) {
		
		theProduct.setProductId(0);
		Product product1= productService.save(theProduct);
		if(product1!=null) {
			return new Response<>(false,"Product added successfully",product1);
		}
		else {
			return new Response<>(true,"product cannot be added",null);
		}
	
	}
	
	
	
	@PutMapping("/products")
	public Response<Product> updateProduct(@RequestBody Product theProduct) {
		
		Product product1 = productService.save(theProduct);
		if(product1!=null) {
			return new Response<>(false,"Product updated successfully",product1);
		}
		else {
			return new Response<>(true,"updation failed",null);
		}
	}
	
	
	
	@DeleteMapping("/products/{productId}")
	public Response<Product> deleteProduct(@PathVariable int productId) {
		
		Product tempProduct = productService.findById(productId);
		if (tempProduct != null) {
			productService.deleteById(productId);
			return new Response<>(false,"Product deleted successfully",tempProduct);
		}	else {
			
			throw new ProductNotFoundException("Product not found");
		}
		

	}
	
	@PostMapping("/register/login")
	public Response<Register> getByEmail(@RequestBody Register register) {
		Register theRegister= productService.getByEmail(register.getEmail(), register.getPassword());
		if (theRegister != null) {
			return new Response<Register>(false, "login successfull", theRegister);
		} else {
			return new Response<Register>(true, "email is not registered", null);
		}
	}
		
	
	@PostMapping("/register")
	public Response<Register> getAllUsers(@RequestBody Register register) {

		Boolean register1 = productService.saveUser(register);
		if (register1 ==true) {
            return new Response<>(false, "successfully saved", register);

		} else {
			return new Response<>(true, "save failed", null);
		}

	}
	
}










