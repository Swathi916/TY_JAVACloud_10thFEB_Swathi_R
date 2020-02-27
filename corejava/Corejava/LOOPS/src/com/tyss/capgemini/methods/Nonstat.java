package com.tyss.capgemini.methods;

public class Nonstat 
{
        public void display()
        {
        	System.out.println("start of called method");
        	System.out.println("hello world");
        	System.out.println("end of called method");
        }
	    public static void main(String[] args)
	    {
		     // new Nonstat().display();
		     
		      Nonstat n1=new Nonstat();
		      System.out.println("start of calling method");
		      n1.display();
		      System.out.println("end of calling method");
		      
	    }
		
}

