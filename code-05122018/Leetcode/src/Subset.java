import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Subset {
	//this is with no dup the idea to implement this here is to get subset(n-1) then copy all the subset(n-1) +subset(n-1)+{n}
	//thsi is for the no duplicate case, what if it has duplicate????
	public static ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> input,int index,ArrayList<ArrayList<Integer>> result)
	{	
		//base case for adding in the empty list
		if(input.size()==index)
		{
			result.add(new ArrayList<Integer>());
		}		
		else
		{
			int item=input.get(index);
			ArrayList<ArrayList<Integer>> temp=getAllSubsets(input, index+1,result);
			ArrayList<ArrayList<Integer>> moretemp=new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> t:temp)
			{
				ArrayList<Integer> more=new ArrayList<Integer>();
				more.addAll(t);
				more.add(item);
				moretemp.add(more);
			}
			result.addAll(moretemp);
		}
		
		return result;
		
	}
	
	
	
	public static void main(String[] args)
	{
		ArrayList<Integer> input=new ArrayList<Integer>();
		input.add(0);
		input.add(1);
		input.add(2);
		input.add(3);
		ArrayList<ArrayList<Integer>> result1=new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result=getAllSubsets(input,0,result1);
		for(ArrayList<Integer> temp:result)
		{
			for(Integer i:temp)
			{
				System.out.print(i);
			}
			System.out.println("");
		}
	}
	
}
