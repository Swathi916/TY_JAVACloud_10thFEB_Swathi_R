package com.tyss.capgemini.methods;

public class Lcm {

	public static void main(String[] args) {
		int a=12;
		int b=15;
		int hcf=0;
		int lcm = 0;
		for (int i=1;i <= a && i <= b;i++) 
		{
			if ((a%i==0) && (b%i==0))
			{
			        hcf = i;
			}
		}
		lcm= (a*b)/hcf;
		System.out.println(hcf);
		System.out.println(lcm);

	}

}
