import java.io.*;
import java.util.*;

public class IsValidBSTMINMAX {
	//using min-max passed down solution to solve the isValidBST problem, this one can handle the duplicate case
	public boolean isValid(TR root) {
          
	     return isValid(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public boolean isValid(TR root, int min, int max)
	{
		if(root==null)
		{
			return true;
		}
		if(root.val<min||root.val>=max)
		{
			return false;
		}
		//when branch out update max, when branch right update the min val.
		return isValid(root.left,min,root.val)&&isValid(root.right,root.val,max);
			
	}
   
	public static void main(String[] args) {
		IsValidBSTMINMAX solution=new IsValidBSTMINMAX();
		TR n5 = new TR(5);
		TR n1 = new TR(1);
		TR n4 = new TR(8);
		TR n3 = new TR(6);
		TR n6 = new TR(10);
		TR n7= 	new TR(9);
		TR n8= 	new TR(11);
		
		n5.left=n1;
		n5.right=n4;
		n4.left=n3;
		n4.right=n6;
		n6.left=n7;
		n6.right=n8;
			
		
		//n5 is the starting node.
		if(solution.isValid(n5)) {
			System.out.println("valid");
		}
		else
		{
			System.out.println("invalid");
		}

	}
}
