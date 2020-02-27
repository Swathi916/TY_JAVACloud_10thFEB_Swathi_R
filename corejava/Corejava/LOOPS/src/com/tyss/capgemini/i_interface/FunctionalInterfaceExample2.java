package com.tyss.capgemini.i_interface;

public interface FunctionalInterfaceExample2 
{
	public int  add(int i ,int j);
	default void printMessage()
	{
		System.out.println(" printmessage method from exampple 2 ");
	}
	public static void print()
	{
		System.out.println(" print method from example2");
	}

}
