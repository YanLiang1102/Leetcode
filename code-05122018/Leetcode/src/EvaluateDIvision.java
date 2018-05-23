import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class EvaluateDivision {
	
	
	/*
	 * just to find if there is a route between two nodes
	 */
	public static void getMultiplyResult(Node start,Node end, HashSet<Node> hash)
	{
		for(Node k:start.neighbors.keySet())
		{
			if(hash.contains(k))
				continue;
			hash.add(k);
			//next=start.neighbors.get(k);
			if(k==end)
			{
			   System.out.println("hey I found it!!!!");
			}			
			getMultiplyResult(k,end,hash);			
		}
	}
	
	/*
	 * return value, return the value in dfs, need to study this hard, learn how to use that break in the mid.
	 */
	public static double getValue(Node start,Node end,HashSet<Node> hash, double value)
	{
		double tmp=0.0;
		for(Node k:start.neighbors.keySet())
		{
			if(hash.contains(k))
			{
				return 0.0;
			}
			double next=start.neighbors.get(k);
			hash.add(k);
 			if(k==end)
			{
				return value*next;
			}
			tmp=getValue(k,end,hash,value*next);
			if(tmp!=0.0)
			{
				//since I found one value already so I don't need to go deeper, something need to learn how to do!!! spend so much time on this.
				break;
			}
		}
		return tmp;
	}

    
    public static void main(String[] args)
    {
    	Node n1=new Node("a");
    	Node n2=new Node("b");
    	Node n3=new Node("c");
    	Node n4=new Node("d");
    	Node n5=new Node("e");
    	Node n6=new Node("f");
    	
    	n1.neighbors.put(n2,10.0);
    	n2.neighbors.put(n3, 2.0);
    	n3.neighbors.put(n4, 3.0);
    	n3.neighbors.put(n5, 4.0);
    	n5.neighbors.put(n6, 2.5);
    	
//    	HashSet<Node> hash=new HashSet<Node>();
//    	hash.add(n1);
//    	getMultiplyResult(n4,n5,hash);
    	
    	double testvalue=getValue(n1,n5,new HashSet<Node>(),1.0);
    	System.out.println(testvalue);
    }
}
