import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class StringPermutationNoDup {
		
	public static List<String> perm(String s)
	{
		List<String> sublist=new ArrayList<String>();
		int len=s.length();
		if(len==0)
		{
			
			//sublist.add("");
			return sublist;
		}
		
		for(int i=0;i<len;i++)
		{
			String before=s.substring(0,i);
			String after=s.substring(i+1,len);
			
			List<String> temp=perm(before+after);
			if(temp.isEmpty())
			{
				sublist.add(s);
			}
			else
			{
				for(String str:temp)
				{
					//System.out.println(s.charAt(i)+str);
					sublist.add(s.charAt(i)+str);
				}
				
			}			
		}
		return sublist;	    
	}

	public static void main(String[] args)
	{
		List<String> result=perm("abc");
		for(String s:result)
		{
			System.out.println(s);
		}
	}
}
