package com.tyss.capgemini.exception;

@SuppressWarnings("serial")
public class InvalidNumberCustomException extends RuntimeException //Exceptionn
{

	public InvalidNumberCustomException(String msg) {
		//System.out.println(msg);
		super(msg);  //along with backtrace

	}

}