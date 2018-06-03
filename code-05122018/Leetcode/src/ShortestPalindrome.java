import java.util.*;

public class ShortestPalindrome {

	//using bruteforce idea to get the shortest prefix at the beginning, this brute force method is O(N^2)
	public static String bruteForce(String pattern)
	{
		String rev=reverse(pattern);
		int index=0;
		for(int i=pattern.length();i>0;i--)
		{
			String subpattern=pattern.substring(0,i);
			String rev1=reverse(subpattern);
			if(rev1.equals(subpattern))
			{
				index=i;
				break;
			}
		}
		
		String suffix=reverse(pattern.substring(index,pattern.length()));
		return suffix+pattern;
	}
	
	/*
	 * the kmp table is based on the pattern string, when you try to find the
	 * substring, need to loop through the bigger string
	 */
	//KMP method will give us O(N) solution 
	public static int[] getKMPtable(String pattern) {
		int len = pattern.length();
		int[] table = new int[len];
		table[0] = 0;
		int j = 0;
		int i = 1;
		while (i < len) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				table[i] = j + 1;
				i++;
				j++;
			} else {
				// when it comes here it means that pattern.charAt(i)!=pattern.charAt(0)
				if (j == 0) {
					table[i] = 0;
					i++;
				} else {
					j = table[j - 1];
				}
			}

		}
		return table;
	}

	public static String reverse(String s) {
		StringBuilder s1 = new StringBuilder();
		s1.append(s);
		s1 = s1.reverse();
		return s1.toString();
	}
	public static void main(String[] args) {
		// String teststring="aacecaaa";
		// String result=ShortestPalindrome(teststring);
		// System.out.println("result is: "+result);
		//
		String pattern = "abcd";
		String newpattern = pattern + "#" + reverse(pattern);
		System.out.println(newpattern);
		int[] table = getKMPtable(newpattern);
		for (int i = 0; i < table.length; i++) {
			System.out.print(table[i] + ",");
		}
		int longestPrefixIndex = table[table.length - 1];
		String suffix = pattern.substring(longestPrefixIndex, pattern.length());
		System.out.println("suffix" + suffix);
		String rst = reverse(suffix) + pattern;
		System.out.println("");
		System.out.println("final result: " + rst);
        
		System.out.println("brute force: "+bruteForce(pattern));
	}

}
