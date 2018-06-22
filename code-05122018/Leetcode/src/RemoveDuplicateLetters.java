import java.util.*;

public class RemoveDuplicateLetters {

	//if using the hashset data structure the order can not be maintained, so "cbacdcbc" return "abcd"
	public static String removeDupLetters(String st)
	{
		
		HashSet<Character> set=new HashSet<Character>();
		for( int i=0;i<st.length();i++)
		{
			char c=st.charAt(i);
			if(set.contains(c))
			{
			  set.remove(c);
			  set.add(c);
			}
			else
			{
				set.add(c);
			}
		}
		//return "";
		StringBuilder sb=new StringBuilder();
		for(Character c:set)
		{
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static String removeDupLetters2(String st)
	{
		LinkedList<Character> ll=new LinkedList<Character>();
		for( int i=0;i<st.length();i++)
		{
			char c=st.charAt(i);
			if(ll.contains((Character)c))
			{
			  int index=ll.indexOf((Character)(c));
			  if(index<ll.size()-1&&(int)c>(int)(ll.get(index+1)))
			  {
				 // ll.remove((Character)(c)); 
				  ll.remove(index);
				  ll.addLast(c);
			  }
			  else
			  {
				continue;  
			  }
			}
			else
			{
				ll.addLast(c);
			}
			
		}
		//return "";
		StringBuilder sb=new StringBuilder();
		for(Character c:ll)
		{
			sb.append(c);
		}
		return sb.toString();
		
	}
	
	public static String removeDupLetters3(String st)
	{
		if(st.isEmpty())
		{
			return "";
		}
		HashMap<Character,Integer> map=buildMap(st);
		int length=st.length();
		Stack<Character> stack=new Stack<Character>();
		stack.push(st.charAt(0));
		boolean[] visited=new boolean[26];
		visited[st.charAt(0)-'a']=true;
		
		for(int i=1;i<length;i++)
		{
		   char curr=st.charAt(i);
		   //if already visited we don't need to care.
		   if(visited[curr-'a'])
		   {
			   map.put(curr,map.get(curr)-1);
			   continue;
		   }
		   while(!stack.empty()&&curr<stack.peek()&&map.get(stack.peek())>1)
		   {
			   char c=stack.peek();			   			   
			   stack.pop();
			   map.put(c,map.get(c)-1);
			   visited[c-'a']=false;
		   }
		   //if the character already in the stack then we don't need to add it in
		   visited[curr-'a']=true;		
		   stack.push(curr);
		}
		
		StringBuilder sb=new StringBuilder();
		while(!stack.empty())
		{
			sb.append(stack.pop());
		}
		return sb.reverse().toString(); 
	}
	
	public static HashMap<Character, Integer> buildMap(String st)
	{
		int length=st.length();
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<length;i++)
		{
			char c=st.charAt(i);
			if(!map.containsKey(c))
			{
				map.put(c, 1);
			}
			else
			{
				map.put(c, map.get(c)+1);
			}
		}
		return map;
	}
	
	public static void main(String[] args)
	{
		
		String testString="bcabc";
		String res=removeDupLetters3(testString);
		System.out.println(res);
		
		String testString1="cbacdcbc";
		String res1=removeDupLetters3(testString1);
		System.out.println(res1);
		
		String testString2="bbcaac";
		String res2=removeDupLetters3(testString2);
		System.out.println(res2);
		
		String testString3="abacb"; //if you don't have visited then what u will have is "abacb"->"acb" but the correct one should be "abc"
		String res3=removeDupLetters3(testString3);
		System.out.println(res3);
		
	}
	
	
}
