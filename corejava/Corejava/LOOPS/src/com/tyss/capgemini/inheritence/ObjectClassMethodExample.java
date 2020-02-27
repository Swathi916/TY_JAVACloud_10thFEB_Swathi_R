package com.tyss.capgemini.inheritence;


public class ObjectClassMethodExample {

	public static void main(String[] args)
	{
	   ObjectClassMethodExample obj=new ObjectClassMethodExample();
	   ObjectClassMethodExample obj1=new ObjectClassMethodExample();
	   
	   // getclass  object
	   System.out.println(obj.getClass());
	   System.out.println(obj);
	   System.out.println(obj1);
	   
	   // hashcode  integer
	   System.out.println(obj.hashCode());
	   
	   //equals  boolean
	   System.out.println(obj.equals(obj1));
	   
	   //tostring
	   System.out.println(obj);
	   System.out.println(obj.toString());
	   
	   
	}

}
