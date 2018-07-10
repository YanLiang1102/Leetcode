/***
my own solution is slow only beat like 8% on leetcode,
so the idea is using m[i] to store the longest substring that is a palindrome end at index i
m[i]=m[i-1]+2 if (the previous palindrom-1==currentindex char) 
else find all the previous j that match current i to see if that is a palindrom from the far left, if so break, since
you already find the longest one. but it can be better, this is very slow what I wrote here.
***/
class Solution {
    public String longestPalindrome(String s) {
          int globalmaxlength=0;
        String globalbest="";
        int length=s.length();
        int[] m=new int[length];
        m[0]=1;
        globalmaxlength=1;
        globalbest=s.substring(0,1);
        for(int i=1;i<length;i++)
        {
            int startindex=i-m[i-1]-1;
            char curr=s.charAt(i);
            if(startindex>0&&s.charAt(startindex)==curr)
            {
                m[i]=m[i-1]+2;
                if(m[i]>globalmaxlength)
                {
                    globalmaxlength=m[i];
                    globalbest=s.substring(startindex,i+1);
                }
                continue;
            }
            //potential
            int potentialindex=s.substring(0,i).indexOf(curr);
            if(potentialindex<0)
            {
            	m[i]=1;
            	 if(m[i]>globalmaxlength)
                 {
                     globalmaxlength=m[i];
                     globalbest=s.substring(i,i+1);
                 }
            	
            }
            while(potentialindex>=0&&potentialindex<i)
            {
                if(isPalindrome(s.substring(potentialindex,i+1)))
                {
                    m[i]=i-potentialindex+1;
                    if(m[i]>globalmaxlength)
                    {
                        globalmaxlength=m[i];
                        globalbest=s.substring(potentialindex,i+1);
                    }
                    potentialindex=-1;
                }
                else
                {
                     potentialindex=potentialindex+1+s.substring(potentialindex+1,i+1).indexOf(curr);
                }
            }
            
            
        }
        return globalbest;
    }
    
   public boolean isPalindrome(String s)
   {
       int i=0;
       int j=s.length()-1;
       while(i<j)
       {
           if(s.charAt(i)!=s.charAt(j))
           {
               return false;
           }
           i++;j--;
       }
       return true;
   }
}
