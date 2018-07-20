/***
classic DP problem, so when ith and jth char not equal , there will be 3 ways for 
word1 to change to word2 that is why we need to take the minimum of the 3 situtations
1. delete will be m[i-1][j]
2.replace will be m[i-1][j-1]
3. add will be m[i][j-1]
***

class Solution {
    public int minDistance(String word1, String word2) {
        if(word1==null||word1.length()==0)
        {
            if(word2==null)
                return 0;
            if(word2!=null)
            {
                return word2.length();
            }
        }     
        
        int l1=word1.length();
        int l2=word2.length();
        //m[i][j] represetnts string with from length i change to length j what is the minimum steps.
        int[][] m=new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++)
        {
            m[i][0]=i;
        }
        for(int j=0;j<=l2;j++)
        {
            m[0][j]=j;
        }
        for(int i=1;i<=l1;i++)
        {
           for(int j=1;j<=l2;j++)
           {
               if(word1.charAt(i-1)==word2.charAt(j-1))
               {
                   m[i][j]=m[i-1][j-1];
               }
               else
               {
                   m[i][j]=Math.min(Math.min(m[i-1][j],m[i-1][j-1]),m[i][j-1])+1;
               }
           }
        }
        return m[l1][l2];
        
        
        
    }
}
