package com.tyss.capgemini.exception;

import java.util.Scanner;

public class TryWithResources {

	public static void main(String[] args) {
		/**
		 * Scanner scan=new Scanner(System.in); if scanner is not closed then resource
		 * leakage will happen can use only try block only if it is with resource
		 * scanner need not to be closed when it is used with resources bcs it implements closeable inturn extends autocloseable class
		 
		 **/

		try (Scanner scan = new Scanner(System.in)) 
		{
			int i = 10;
			int j = scan.nextInt();
			// System.out.println(i/j);

			if (j == 0)
				System.err.println("should not divide by 0");
			else
				System.out.println(i / j);

		}
		/*
		 * catch (Exception e) {
		 * System.err.println("should not divide a number by zero.....");
		 * System.err.println(e.getMessage()); }
		 */
	}
	

}
