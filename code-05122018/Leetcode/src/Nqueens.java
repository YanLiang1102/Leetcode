import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class NQueens {
	
	
	// main idea: each columns configuration will map out to a ArrayList<String> solution
	public static void helper(ArrayList<ArrayList<String>> result,ArrayList<Integer> cols, int n)
	{
		if(cols.size()==n)
		{
		    result.add(drawBoard(cols,n));
			return;
		}
		//otherwise recursively explore what the cols will look like.
		for(int i=0;i<n;i++)
		{
			if(!isValid(cols,i))
			{
				continue;
			}
			else {
				cols.add(i);
				helper(result,cols,n);
				cols.remove(cols.size()-1);
			}
		}		
	}
	
	//using the the cols info to draw the solution out
	public static ArrayList<String> drawBoard(ArrayList<Integer> cols,int n)
	{
		
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0;i<n;i++)
		{
			String temp="";
			int col=cols.get(i);
			for(int j=0;j<n;j++)
			{
				if(j!=col)
				{
					temp+=".";
				}
				else {
					temp+="q";
				}
			}
			result.add(temp);
		}
		return result;
	}
	
	//cols will store what is the col quene is at ith row, j=cols.get(i) means on the ith row the queen will be at column j
	public static boolean isValid(ArrayList<Integer> cols, int col)
	{
		int size=cols.size();
		for(int i=0;i<size;i++)
		{
		   //col is on which posion the new queen is going to be added
		   if(cols.get(i)==col)
		   {
			   return false;
		   }		 		  
		   //assume that it will be added to the next row
		   //Math.abs is necessary!!! since the diagnal could be on 4 corners if the previous queen is on the right up corner of the current 
		   //queen, then you will definitely need this!
		   if(Math.abs(i-size)==Math.abs(cols.get(i)-col))
		   {
			   //this means they are on the same diagonal.
			   return false;
		   }
		}
		//otherwise putting a queen on this column and row is allowed!
		return true;
		
	}
	
	public static void main(String[] args)
	{
	  ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
	  ArrayList<Integer> cols=new ArrayList<Integer>();
	 	  
	 helper(result,cols,5);
	 for(ArrayList<String> l:result)
	 {
		 for(String s:l)
		 {
			 System.out.print(s);
		 }
		 System.out.println("end");
	 }
	  
	}
}
