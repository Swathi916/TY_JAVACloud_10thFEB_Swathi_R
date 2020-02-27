package com.tyss.capgemini.strings;

public class StringBufferExample {

	public static void main(String[] args)
	{
	   //StringBuffer sb="some string";  not possible
		String string="some string";
		StringBuffer sb=new StringBuffer("some string buffer");
		StringBuffer sb1= new StringBuffer(string);//converting from string to string buffer
		System.out.println(sb1);

		System.out.println(sb1.getClass());
	     sb1.append("buffer");
	     System.out.println(sb1);
	     
	     System.out.println(sb1.reverse());
	     System.out.println(sb1.reverse());
	     
	     // to replace
	    System.out.println(sb1.replace(0, 1, "S")); //can replace particular letter
	    System.out.println(sb1.insert(5,"ABC"));     //INSERT
	    System.out.println(sb1.indexOf("xyz"));   
	    System.out.println(sb1.indexOf("AB"));   //-1 means it is not present in the string
	    System.out.println(sb1.delete(5, 8));
	     
	     

	}

}

