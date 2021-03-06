package com.tyss.capgemini.inheritence;

import com.tyss.capgemini.i_interface.AnotherMethodInterface;
import com.tyss.capgemini.i_interface.MethodsInterface;

public class InterfaceImplClass implements MethodsInterface, AnotherMethodInterface
{

	@Override
	public void print() {
		System.out.println("overriden print implementation");
		
	}
	@Override
	public void displayMessage() {
		System.out.println("overriden display implementation");
		
	}

	@Override
	public void messageDisplay() {
		System.out.println("oveeriden messagedisplay");
		
	}
	public static void main(String[] args)
	{
		// ref variable
		MethodsInterface  mi= new InterfaceImplClass();
		mi.displayMessage();
	    mi.print();
	    AnotherMethodInterface a1= new InterfaceImplClass();
	    a1.messageDisplay();
	    
	    //or
	    
	    InterfaceImplClass i1=new InterfaceImplClass();
	    i1.displayMessage();
	    i1.displayMessage();
	    i1.print();
			
			
	}
	
}
