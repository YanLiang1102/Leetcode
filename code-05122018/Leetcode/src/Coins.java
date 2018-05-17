import java.io.*;
import java.util.*;
import java.util.LinkedList;

//I entirely create teh whole solution by myself!!
public class Coins {

	// target will be for example 100 cents and we have 1 cent, 5 cents, 10 cents and 25 cents to build all the things up.
	static int count=0;
    public static void makeCoins(int target,int[] moneychange, int runningsum,int moneychangeindex)
    {
     	int remain=target-runningsum;
     	
    	if(remain==0)
    	{
    		count++;
    		return;
    	}
    	if(remain<0)
    	{
    		return;
    	}
    
       	for(int i=moneychangeindex;i<moneychange.length;i++)
    	{
       		int change=moneychange[i];
       		//this means it still have room to add in one more number with c.
    		if(remain/change>0)
    		{
    			//this has to start consider i, not for the beginning again, otherwise it might have duplicate like 6=5+1 and 6=1+5 will be considered two solutions.
    			makeCoins(target,moneychange,runningsum+change,i);
    		}
    		
    	}
    }
	public static void main(String[] args)
	{	
		int[] moneychange=new int[] {25,10,5,1};
		System.out.println("before");
		makeCoins(25,moneychange,0,0);
		System.out.println(count);			
		System.out.println("after");			
	}                                     
	
	
}
