import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class FindMaximumDifference {
	/*
	 * idea is bottom up and find the minimum of left subtree and right subtree and
	 * use the node value to substrat
	 */

	//this is not the preferred solution, since the findMinOfTree will is also a recusive function 
	public static int findMaxDiff(TR root, int max) {
		//find the min of the subtree then using the current node to minus that, 
		
	    if(root==null)
	    {
	    	return max;
	    }
		int val=root.val;
		//could have the overflow here if you use Integer.MAX_VALUE
	    int currentMax=Math.max(val-findMinOfTree(root.left,1000), val-findMinOfTree(root.right,1000));
	    if(currentMax>max)
	    {
	       max=currentMax;
	    }
	    int leftmax=findMaxDiff(root.left,max);
	    int rightmax=findMaxDiff(root.right,max);
	    return Math.max(leftmax,rightmax);
	}

	public static int findMinOfTree(TR root, int min) {
		if (root == null) {
			return min;
		}
		if (root.val < min) {
			min = root.val;
		}
		return Math.min(findMinOfTree(root.left, min), findMinOfTree(root.right, min));
	}

	public static void main(String[] args) {

		TR n4 = new TR(-10);
		TR n5 = new TR(5);
		TR n2 = new TR(-3);
		TR n6 = new TR(-8);
		TR n1 = new TR(-4);
		n4.left = n5;
		n4.right = n2;
		n2.left = n6;
		n2.right = n1;

		int min = findMinOfTree(n4, Integer.MAX_VALUE);
		System.out.println(min);
		System.out.println("here is the max diff: ");
		int max=findMaxDiff(n4,Integer.MIN_VALUE);
		System.out.println(max);
		
		TR t8=new TR(8);
		TR t3=new TR(3);
		TR t10=new TR(10);
		TR t1=new TR(-2);
		TR t6=new TR(6);
		TR t4=new TR(4);
		TR t7=new TR(7);
		TR t14=new TR(14);
		TR t13=new TR(13);
		
		t8.left=t3;
		t8.right=t10;
		t3.left=t1;
		t3.right=t6;
		t6.left=t4;
		t6.right=t7;
		t10.right=t14;
		t14.left=t13;
		System.out.println("another tree");
		int newmax=findMaxDiff(t8,Integer.MIN_VALUE);
		System.out.println(newmax);
	}

}



