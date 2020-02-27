package com.tyss.capgemini.methods;

public class Arith {
	public Arith(int a) 
	{
		System.out.println("Basic arithmetics.......");
	}
	/**
	 * This method returns the sum of 2 given integer.
	 * @param i
	 * @param j
	 * @return
	 */
	//used to get description of the methods
	public static int add(int i, int j)
	{
		return i+j;
	}
	
	/**
	 * this method give the difference of two integer.
	 * @param i
	 * @param j
	 * @return
	 */
	public static int sub (int i, int j )
	{
		return i-j;
	}
	/**
	 * this gives the quotient.
	 * @param i
	 * @param j
	 * @return
	 */

      public static double div (int i, int j )
     {
	    return  (1.0*i)/j;     //or by changing the datatype of any one of the parameter to double
     }
    
	// A method can have only one return statement
    // Return statement is used to bring back the control to calling method 
      
	public static void main(String[] args) 
	{
		//for println should press control...and select open declaration.
       int sum=  add(5,10);
         System.out.println(sum);
         
        int res= sub(10,5);
        System.out.println( res);
        
        double div1=div(15,2);
        System.out.println(div1);
        

	}

}
