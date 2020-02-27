package com.tyss.capgemini.loops;

public class Forex {

	public static void main(String[] args)
	{
		System.out.println("loop1..............");
		
         for(int i=1;i<=10;i++)
         {
        	 System.out.println(i*13);
         }
         System.out.println("loop 2..................");
         for(int i=0;i<10;i++)
         {
        	 System.out.println((i+1)*13);
         }
         System.out.println("loop3...........");
         int j=0;
         for(; j<10;j++)
         {
        	 System.out.println((j+1)*12);
         }
         System.out.println("loop4..........");
         int k=0;
         for(; k<10;)
         {
        	 System.out.println((k+1)*12);
        	 k++;
         }
	}

}
