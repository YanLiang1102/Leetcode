import java.util.*;

public class WordBreak2 {

	//using dfs to find all the solutions. this can be a helper method on leetcode, 
	//since the parameter required on leetcode is only "String s and List<String> wordDict".
	public static void getAllSolutions(String s, List<String> wordDict,ArrayList<ArrayList<String>> result, ArrayList<String> one,int index) {
		
		if(index==s.length())
		{
			result.add(new ArrayList<String>(one));
			return;
		}
 		for(int i=index;i<=s.length();i++)
		{
			String curr=s.substring(index, i);
			
			if(wordDict.contains(curr))
			{
				one.add(curr);				
				getAllSolutions(s,wordDict,result, new ArrayList<String>(one),i);	
				one.remove(one.size()-1);
			}
			
		}
	}
	
	//this test can not be passed why, how to fix this problem.
//	"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
	//["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
	

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
		ArrayList<String> one=new ArrayList<String>();

		List<String> wordDict=new ArrayList<String>();
//		String s="catsanddog";
//		wordDict.add("cat");
//		wordDict.add("cats");
//		wordDict.add("and");
//		wordDict.add("sand");
//		wordDict.add("dog");
		
//		String s="pineapplepenapple";
//		wordDict.add("apple");
//		wordDict.add("pen");
//		wordDict.add("applepen");
//		wordDict.add("pine");
//		wordDict.add("pineapple");
	
//		String s="catmn";
//	    wordDict.add("cat");
//	    wordDict.add("m");
//	    wordDict.add("n");
//	    wordDict.add("mn");
		
		//String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String s="aaaaa";
		wordDict.add("a");
		wordDict.add("aa");
		wordDict.add("aaa");
		wordDict.add("aaaa");
		wordDict.add("aaaaa");
		wordDict.add("aaaaaa");
		wordDict.add("aaaaaaa");
		wordDict.add("aaaaaaaa");
		wordDict.add("aaaaaaaaa");
		wordDict.add("aaaaaaaaaa");
	
		getAllSolutions(s,wordDict,result,one,0);
		for(ArrayList<String>item:result)
		{
		    for(String i:item)
		    {
		    	System.out.print(i+",");
		    }
		    System.out.println("");
		}
		
		
		
	}

}
