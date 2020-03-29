package com.capgemini.loanProcessingSystem.exception;

public class UserNameAlreadyExistsException extends RuntimeException {
	
		
		String msg = "Username already exist";

		public UserNameAlreadyExistsException() {
		}
		
		public  UserNameAlreadyExistsException(String msg) {
			this.msg = msg;
		}
		
		@Override
		public String getMessage() {
			return msg;
		}
	
}
