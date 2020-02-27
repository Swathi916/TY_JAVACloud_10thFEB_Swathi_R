package com.tyss.capgemini.object;

public class Exforobj {
	//zero argument constructor
	public Exforobj()
	{
		System.out.println("Zero argument constructor.......");
	}
	// parameterised constructor
	  Exforobj(String string)
	  {
		  System.out.println(" constructor with one arguments");
		  
	  }
	  Exforobj (int a, String b)
	  {
		  System.out.println("constructor with 2 arguments");
	  }
	  Exforobj (String a, int b)
	  {
		  System.out.println("constructor with interchanged arguments");
	  }
 // once a constructor is created then compiler wont create default constructor
	public static void main(String[] args)
	{
		Exforobj e1=new Exforobj();
		Exforobj e2=new Exforobj("hello");
		Exforobj e3=new Exforobj("hello",10);
		Exforobj e4=new Exforobj(10,"hello");
	
		  
     }

}
