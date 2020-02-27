package com.tyss.capgemini.inheritence;

public class Subclass  extends SuperClass
{
    public String print() 
    {
    	return "some other string";
    
     }
    public void display()
    {
    	System.out.println("sub class");
    }
	public static void main(String[] args) 
	
	{
		
          SuperClass Sc= new SuperClass();
          System.out.println(Sc.print());
          
          Subclass sc=new Subclass();
          System.out.println(sc.print());
          
          System.out.println("............casting...........");
          
          //upcasting
          SuperClass s1= new Subclass();
          
          // downcasting
          Subclass s2=(Subclass) s1;
          
          System.out.println(s1.print());
          System.out.println(s2.print()); 
          
           new Subclass().display();
   
	}

}
