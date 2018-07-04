/**
 * this is just practise again, the idea is top down to get the maxdiff, but bottom up to get the min, very nice problem
 * @author yan
 *
 */
import java.util.*;

//class help 
//{
//	int minvalue;
//	int globalmax;
//	public help(int minvalue)
//	{
//		this.minvalue=minvalue;
//		//this.globalmax=globalmax;
//	}
//	
//}

public class FindMaximumDifference2 {
	
	public static int findMax(TR root,int[] max)
	{
		int min=Integer.MAX_VALUE;
		
		if(root==null)
		{
			return min;
		}
		
		if(root.left==null&&root.right==null)
		{
			return root.val;
		}
		else
		{
			min=Math.min(findMax(root.left,max),findMax(root.right,max));
			max[0]=Math.max(max[0], root.val-min);
		}
		return min;
	}
	
	
	
	public static void main(String[] args)
	{
		TR root=new TR(8);
		TR n3=new TR(3);
		TR n10=new TR(10);
		TR n1=new TR(1);
		TR n6=new TR(6);
		TR n14=new TR(14);
		TR n4=new TR(4);
		TR n7=new TR(7);
		TR n13=new TR(13);
		
		root.left=n3;
		root.right=n10;
		n3.left=n1;
		n3.right=n6;
		n6.left=n4;
		n6.right=n7;
		n10.right=n14;
		n14.left=n13;
		int[] max=new int[1];
		max[0]=Integer.MIN_VALUE;
		int data=findMax(root,max);
		System.out.println(max[0]);
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	}
}
