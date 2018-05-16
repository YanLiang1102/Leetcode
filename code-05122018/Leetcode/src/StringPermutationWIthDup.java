import java.io.*;
import java.util.*;
public class StringPermutationWithDup {
	
	public static void perm(HashMap<Character,Integer> hash, int length, String prefix,List<String>result)
	{
		
		if(prefix.length()==length)
		{
			result.add(prefix);
			return;
		}
		for(char c: hash.keySet())
		{
			int count=hash.get(c);
			if(count>0)
			{
				//backtracking.
				hash.put(c, count-1);
				perm(hash, length,prefix+c,result);
				hash.put(c, count);				
			}
			
		}
	   
	}
	
	public static HashMap<Character,Integer> buildHash(String s)
	{
		HashMap<Character,Integer> hash=new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++)
		{
			if(!hash.containsKey(s.charAt(i)))
			{
				hash.put(s.charAt(i),1);
			}
			else
			{
				int oldcount=hash.get(s.charAt(i));
				hash.put(s.charAt(i), oldcount+1);
			}
		}
		return hash;		
	}
	
	

	public static void main(String[] args)
	{
		String teststring="abbb";
		List<String> result=new ArrayList<String>();
		HashMap<Character,Integer> hash=buildHash(teststring);
		perm(hash,teststring.length(),"",result);
		
		for(String s: result)
		{
			System.out.println(s);
		}
	}

}
