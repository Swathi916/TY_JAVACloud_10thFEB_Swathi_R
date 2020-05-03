package com.tyss.springboot.asg.exception;

public class ProductNotFoundException extends RuntimeException {
	public  ProductNotFoundException(String message) {
		super(message);
	}

}
