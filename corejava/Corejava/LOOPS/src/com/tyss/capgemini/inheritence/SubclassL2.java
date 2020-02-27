package com.tyss.capgemini.inheritence;

public class SubclassL2 extends Subclass {
    public void display() {
    	super.display();
    	super.i=20;//even this
    	System.out.println("overriden1");
    								
}
 
    public String  print()
    {
    	System.out.println("overriden");
    	return super.print();
    }
	public static void main(String[] args) {
	   
          SubclassL2 sl2= new SubclassL2();
          sl2.display();
          System.out.println(sl2.print());
          System.out.println("int i of superclass:"+ sl2.i);
          // reinitialising i should be done inside a method 
          
          System.out.println(sl2.i);
	}

}
