import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class WeaveList {

	//this is one of the function for the problem on cracking the interview page 263 BST sequence problem,
	//this is to weave two list together but remain the order of each original list.
	
    public static ArrayList<ArrayList<Integer>> weaveList(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> one, ArrayList<Integer>list1,ArrayList<Integer>list2,
    		int size, int pos1,int pos2)
    {
    	if(one.size()==size)
    	{
    		result.add(new ArrayList<Integer>(one));
    	}
    	for(int i=pos1;i<list1.size();i++)
    	{
           one.add(list1.get(i));
           weaveList(result,one,list1,list2,size,i+1,pos2);
           one.remove(one.size()-1);    		
    	}
    	for(int i=pos2;i<list2.size();i++)
    	{
    		one.add(list2.get(i));    		
            weaveList(result,one,list1,list2,size,pos1,i+1);
            one.remove(one.size()-1);
    	}
    	
    	return result;
    	
    }
	
	public static void main(String[] args)
	{
		ArrayList<Integer> l1=new ArrayList<Integer>();
		ArrayList<Integer> l2=new ArrayList<Integer>();
		
		l1.add(1);
		l1.add(2);
		l2.add(3);
		l2.add(4);
		
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
				weaveList(result,new ArrayList<Integer>(),l1,l2,4,0,0);
		for(ArrayList<Integer> l:result)
		{
			for(int i:l)
			{
				System.out.print(i+",");
			}
			System.out.println("end");
		}
	}
}
