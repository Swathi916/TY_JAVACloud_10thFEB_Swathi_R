package com.tyss.capgemini.exception;

import java.util.Scanner;


public class CustomExceptionTester {
  public static void main(String[] args) throws InvalidNumberCustomException
  {
	Scanner scan=new Scanner(System.in);
	System.out.println("enter the no: ");
	int no=scan.nextInt();
	scan.close();
	if (no >= 0 && no <= 10 ) {
		System.out.println(no*10);
	}
	else
	{
		throw new InvalidNumberCustomException("custom exception message");
	}
	
}
}