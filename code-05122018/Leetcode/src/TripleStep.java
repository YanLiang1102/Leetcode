import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class TripleStep {

	public static int tripleSolution(int n)
	{
		if(n==0)
		{
			return 0;
		}
		if(n==1)
		{
			return 1;
		}
		if(n==2)
		{
			return 2;
		}
		if(n==3)
		{
			return 4;
		}
		return tripleSolution(n-1)+tripleSolution(n-2)+tripleSolution(n-3);
	}
	
	//thsi is the solution on the book but this is still a lot of calculation like fabinacci it has too much recalculated stuff.
	public static int tripleSolution2(int n)
	{
		if(n<0)
		{
			return 0;
		}
		else if(n==0)
		{
			return 1;
		}
		else
		{
			return tripleSolution2(n-1)+tripleSolution2(n-2)+tripleSolution2(n-3);
		}
		
	}
	
	//optmizied use mem to remember what has been calculated
	public static int optimized(int n,int[] mem)
	{
		if(n<0)
		{
			return 0;
		}
		if(n==0)
		{
			return 1;
		}
		if(mem[n]>-1)
		{
			return mem[n];
		}
		mem[n]=optimized(n-3,mem)+optimized(n-2,mem)+optimized(n-1,mem);
		return mem[n];
	}
	
	public static void main(String[] args)
	{
		int count=tripleSolution(4);
		System.out.println(count);
		
		int count1=tripleSolution2(4);
		System.out.println(count1);
		
		int[] mem=new int[5];
		Arrays.fill(mem, -1);
		int count2=optimized(4,mem);
		System.out.println(count2);
	
	}
}
