package com.tyss.springboot.asg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tyss.springboot.asg.entity.Register;
import com.tyss.springboot.asg.response.Response;

@ControllerAdvice
public class GenericExceptionHandler {
	

		@ExceptionHandler
		public ResponseEntity<Response<Register>> handleException(UserNotFoundException ex) {

			Response<Register> response = new Response<>(true, ex.getMessage(), null);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

		}

	}



