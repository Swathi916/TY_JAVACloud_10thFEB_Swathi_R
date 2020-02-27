package com.tyss.capgemini.methods;

public class Methodoverriding extends Methods
{
        public String printMessage() 
        {
  
        	return "Non-static methodoverriding.printmessage()";
        }
       
        int addingTwoInteger(int i,int j)
        {
        	return super.addingTwoInteger(i,j);
        }
       public static void main(String[] args) {
		System.out.println(new Methodoverriding().printMessage());//without ref variable
		System.out.println(Methods.displayMessage());
		System.out.println(displayMessage());
	}
 
}
