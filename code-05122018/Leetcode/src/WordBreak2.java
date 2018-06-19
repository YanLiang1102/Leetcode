import java.util.*;

public class WordBreak2 {
	
	//thsi is only dfs without memeorization will get time out
	public static void getAllSolutions(String s,List<String>wordDict,ArrayList<ArrayList<String>>result, ArrayList<String> one, int index)
	{
		if(index==s.length())
		{
			result.add(new ArrayList<String>(one));
			return;
		}
		for(int i=index;i<s.length();i++)
		{
			String curr=s.substring(index, i+1);
			if(wordDict.contains(curr))
			{
				one.add(curr);
				//this has to be i+1, in that way that index==s.length() can be passed otherwise, it will never get passed.
				getAllSolutions(s,wordDict,result,one,i+1);
				one.remove(one.size()-1);
			}
		}
		
	}
	//using dfs with memorization will solve the time out problem.
	public static List<String> dfsWithMemorization(String s, List<String>wordDict, HashMap<String,List<String>>map)
	{
		if(map.containsKey(s))
		{
			return map.get(s);
		}
		
		List<String> res=new ArrayList<String>();
		for(String word:wordDict)
		{
			if(s.startsWith(word))
			{
				String remaining=s.substring(word.length());
				List<String>temp=dfsWithMemorization(remaining, wordDict,map);
				//thsi means that when the string is "", the res will be empty so the loop will not run at all, so nothing will be added in , so we need this check.
				if(temp.isEmpty())
				{
					res.add(word+" ");
				}
				else
				{
					for(String item:temp)
					{
						res.add(word+" "+item);
					}

				}
			}
		}
		map.put(s, res);
		return res;
	}
	
	public static List<String> dfsWithMemorization2(String s, List<String>wordDict, HashMap<String,List<String>>map)
	{
		if(map.containsKey(s))
		{
			return map.get(s);
		}
		
		List<String> res=new ArrayList<String>();
		//this is another strategy to solve the problem.
		if(s.equals(""))
		{
			res.add("");
			return res;
		}
		for(String word:wordDict)
		{
			if(s.startsWith(word))
			{
				String remaining=s.substring(word.length());
				List<String>temp=dfsWithMemorization(remaining, wordDict,map);
				//thsi means that when the string is "", the res will be empty so the loop will not run at all, so nothing will be added in , so we need this check.

					for(String item:temp)
					{
						res.add(word+" "+item);
					}

			
			}
		}
		map.put(s, res);
		return res;
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
		
		String s="pineapplepenapple";
		wordDict.add("apple");
		wordDict.add("pen");
		wordDict.add("applepen");
		wordDict.add("pine");
		wordDict.add("pineapple");
	
//		String s="catmn";
//	    wordDict.add("cat");
//	    wordDict.add("m");
//	    wordDict.add("n");
//	    wordDict.add("mn");
		
		HashMap<String, List<String>>map=new HashMap<String,List<String>>();
		List<String> res=dfsWithMemorization2(s,wordDict,map);
		for(String str:res)
		{
			System.out.println(str);
		}
	
//		getAllSolutions(s,wordDict,result,one,0);
//		for(ArrayList<String>item:result)
//		{
//		    for(String i:item)
//		    {
//		    	System.out.print(i+",");
//		    }
//		    System.out.println("");
//		}
//		
//		String test="hello oklahoma";
//		System.out.println(test.substring(4));
		
		
		
	}

}
