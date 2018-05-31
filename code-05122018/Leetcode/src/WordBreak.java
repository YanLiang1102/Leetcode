import java.util.*;

public class WordBreak1 {

	/*
	 * the idea is use a boolean list to remember if the word can be seperated or
	 * not
	 */
	public static boolean IsWordBreak(String s, List<String> wordDict) {
		if (wordDict == null || s == null || wordDict.size() == 0) {
			return false;
		}

		int stringlength = s.length();
		int maxwordlength = findMaximumLength(wordDict);
		boolean[] canbreak = new boolean[stringlength + 1];
		canbreak[0] = true;
		for (int i = 1; i <=stringlength; i++) {
			canbreak[i] = false;
			// looking at character i and for teh [0-i] string look from teh back to see if
			// it is canbreak.
			for (int lastword = 1; lastword <= i  && lastword <= maxwordlength; lastword++) {
				// to see if the prefix can be break, and the length of the prefix is i-lastword
				if (!canbreak[i - lastword]) {
					continue;
				}
				//the index is i-lastword-1
				if (wordDict.contains(s.substring(i - lastword, i))) {
					canbreak[i]=true;
					break;
				}
			}
		}
		return canbreak[stringlength];
	}

	public static int findMaximumLength(List<String> wordDict) {
		int max = Integer.MIN_VALUE;
		for (String word : wordDict) {
			max = Math.max(word.length(), max);
		}
		return max;

	}

	public static void main(String[] args) {
		List<String> wordDict=new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		String s="leet1codecode";
		boolean result=IsWordBreak(s,wordDict);
		if(result)
		{
		  System.out.println("this is true!!");	
		}
		else
		{
	      System.out.println("this is false");
		}
//		String test="hell";
//		System.out.println(test.substring(3,4));
		
	}

}
