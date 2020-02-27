package com.tyss.capgemini.inheritence;

import com.tyss.capgemini.methods.Methods;

public class DifferentPackageOverridingclass extends Methods

{
      public String printMessage() {
    	  return super.printMessage();
		
	   }
      protected String welcomeMessage()
      {
    	  return "hello world";
      }
      public static void main(String[] args)
      {
		DifferentPackageOverridingclass dp= new DifferentPackageOverridingclass();
		System.out.println(dp.printMessage());
		System.out.println(dp.welcomeMessage());
	  }
}    
