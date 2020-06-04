package com.capgemini.lps.response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleCustomValidationError(MethodArgumentNotValidException e){
		Response<?> response = new Response(true,e.getBindingResult().getFieldError().getDefaultMessage(),new ArrayList());
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}

