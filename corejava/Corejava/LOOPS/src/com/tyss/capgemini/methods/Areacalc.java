package com.tyss.capgemini.methods;

		public class Areacalc {
			
			public  int sq(int side)
			{
				return side*side;
			}
			
			
			public int rec (int len, int bre )
			{
				return len*bre;
			}
		

		      public  double cir (int radius )
		     {
		    	final double pi=3.14;
			    return   pi*radius*radius;
		     }
		    
			
			public static void main(String[] args) 
			{
				Areacalc a1=new Areacalc();
				System.out.println(a1.sq(5));
				System.out.println(a1.rec(5,10));
				System.out.println(a1.cir(5));
		    

			}

		

	}


