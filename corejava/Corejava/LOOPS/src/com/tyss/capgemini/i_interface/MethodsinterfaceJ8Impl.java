package com.tyss.capgemini.i_interface;

public class MethodsinterfaceJ8Impl implements MethodsInterface
{

	@Override
	public void displayMessage() {
		System.out.println(" overriden display of method interface");
		
	}

	@Override
	public void print() {
		System.out.println("overriden implementation of print of method interface");
		
	}
	public static void main(String[] args) {
		MethodsinterfaceJ8Impl mij=new  MethodsinterfaceJ8Impl();
		mij.displayMessage();
		mij.print();
		mij.defaultMessage();
		MethodsInterface.showMessage();
		
	}

}

