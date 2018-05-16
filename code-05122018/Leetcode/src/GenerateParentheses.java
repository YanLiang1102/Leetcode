import java.io.*;
import java.util.*;
import java.util.LinkedList;
	
public class GenerateParentheses {

    public static List<String> getParentheses(int n)
    {
    	List<String> rst=new ArrayList<String>();
    	helper("",n,0,0,rst);
    	return rst;
    }
	public static void helper(String base, int max, int open, int close, List<String>rst)
	{
		if(base.length()==2*max)
		{
			rst.add(base);
		}
		
		if(open<max)
		{
		   helper(base+"(",max,open+1,close, rst);
		}
		if(close<open)
		{
			helper(base+")",max,open,close+1,rst);
		}
		
		
	}
	
	public static void main(String[] args)
	{
		List<String> test=getParentheses(3);
		for(String a:test)
		{
		  System.out.println(a);
		}
		
	}
}
