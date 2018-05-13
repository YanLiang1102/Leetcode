import java.io.*;
import java.util.*;

public class IsValidBST {
	// Definition for a binary tree node.
	boolean global=true;
	public boolean isValid(TR root) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		int lastone=Integer.MIN_VALUE;
		return copyBST(root,lastone);
	}
   
	private boolean copyBST(TR root,int lastone) {
		//System.out.println("I got here!");
		if (root == null)
			return true;
		System.out.println(root.val);
		if(!copyBST(root.left,lastone))
			return false;
		if(root.val<lastone)
			return false;
		else
			lastone=root.val;
		    System.out.println("lastone: "+lastone);
		if(!copyBST(root.right,lastone))
			return false;
		return true;
	}

	public static void main(String[] args) {
		IsValidBST solution=new IsValidBST();
		TR n5 = new TR(5);
		TR n1 = new TR(1);
		TR n4 = new TR(2);
		TR n3 = new TR(3);
		TR n6 = new TR(7);
		TR n7= 	new TR(6);
		TR n8= 	new TR(9);
		
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
