package com.tyss.capgemini.i_interface;

public class FunctionalInterfaceLambdaExample 
{
      static String string="hello";
      static FunctionalInterfaceExample fi=()->{
    	  System.out.println(string);
    	  System.out.println("hello world");
      };
	
		static FunctionalInterfaceExample2 ffe=(i,j)->i+j;
		{
			System.out.println("lambda...");
		};
		public static void main(String[] args) {
			
			fi.showMessage();
			fi.printMessage();
			FunctionalInterfaceExample.displayMessage();
			int i=ffe.add(4,5);
		}
	}
      
