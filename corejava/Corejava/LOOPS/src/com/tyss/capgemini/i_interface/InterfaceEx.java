package com.tyss.capgemini.i_interface;

public interface InterfaceEx
{
	void test();
	void demo();
	static void message()
	{
		System.out.println("Hello World");
	}
	default void display()
	{
		System.out.println(" Display Message");
	}

}
