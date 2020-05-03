package com.tyss.springboot.asg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tyss.springboot.asg.entity.Product;
import com.tyss.springboot.asg.response.Response;

public class ProductExceptionHandler {
@ExceptionHandler
public ResponseEntity<Response<Product>> handleException(ProductNotFoundException ex){
	Response<Product> response = new  Response<>(true,ex.getMessage(),null);
	return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
}
}
