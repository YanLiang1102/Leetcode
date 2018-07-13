/****
just return boolean value to see if the word can be break or not.
****/
import java.util.*;

class IfWordCanBeBreak  {
	 public boolean wordBreak(String s, List<String> wordDict) {
	        // using a boolean to store at the end of the current character if it can be splitted or not
	        int length=s.length();
	        boolean[] m=new boolean[length+1];
	        m[0]=true;
	        
	        int longest=findLongestWordInWorddict(wordDict);
	        for(int i=1;i<=length;i++)
	        {
	            //this should be j<=i since it can consider the whole string in the dictionary or not.
	            for(int j=1;j<=i&&j<=longest;j++)
	            {
	                if(m[i-j]&&wordDict.contains(s.substring(i-j,i)))
	                {
	                    m[i]=true;
	                    break;
	                }
	            }
	        }
	        return m[length];
	        
	    }
	    
	    public int findLongestWordInWorddict(List<String> wordDict)
	    {
	        int longest=0;
	        for(String s:wordDict)
	        {
	            int len=s.length();
	            longest=Math.max(longest,len);
	        }
	        return longest;
	    }
    
    public static void main(String[] args)
    {
    	List<String> wordDict=new ArrayList<String>();
    	wordDict.add("leet");
    	wordDict.add("code");
    	String s="leetcode";
    	IfWordCanBeBreak ins=new IfWordCanBeBreak();
    	boolean canbreak=ins.wordBreak(s, wordDict);
    	if(canbreak)
    	{
    		System.out.println("this can be break!!!");
    	}
    	else
    	{
    		System.out.println("this can not be break!!!");
    	}
       
    }
}
