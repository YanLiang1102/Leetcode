public class Solution {
    public int lengthLongestPath(String input) {
        
        String[] stri=input.split("\n");
        int[] stack=new int[stri.length+1];
        int lev=0;
        int currentLen=0;
        int maxLen=0;
        for(String item :stri)
        {
            lev=item.lastIndexOf("\t")+1;
            
            currentLen=stack[lev+1]=stack[lev]+item.length()-lev+1; // "/t" the length of the string is 1,
           // this 1 is for the last / that need to append to the 
            if(item.contains("."))
            {
                maxLen=Math.max(maxLen,currentLen-1);
            }
        }
        return maxLen;
        
    }
}