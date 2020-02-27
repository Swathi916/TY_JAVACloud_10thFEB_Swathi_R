import java.util.*;


public class Exm {

	public static void main(String[] args)
	{
     Scanner scan=new Scanner(System.in);
     int no= scan.nextInt();
       int num=0;       
        while(num<=no)
        {
        	if(no%2==0)
        	{
        		System.out.println("even");
        		num++;
        	}
        	else
        	{
        		System.out.println("odd");
        		  break;
        	}
        }
	}

}
