package com.tyss.capgemini.i_interface;

public class FunctionalInterface  implements FunctionalInterfaceExample,FunctionalInterfaceExample2
{
	public void showMessage() {
		System.out.println("overriden implementation of show message");
		
	}
	
	public int add(int i,int j)
	{
		return i+j;
		
	}
	
	@Override
	public void printMessage() {
		// TODO Auto-generated method stub
		FunctionalInterfaceExample.super.printMessage();
	}

	public static void main(String[] args)
	{
		FunctionalInterface fi= new FunctionalInterface();
		fi.showMessage();
		fi.printMessage();
	    FunctionalInterfaceExample.displayMessage();
	    System.out.println(fi.add(3,4));
	    FunctionalInterfaceExample2.print();
	    
	}

}
