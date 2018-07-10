/***
my own solution is slow only beat like 8% on leetcode,
so the idea is using m[i] to store the longest substring that is a palindrome end at index i
m[i]=m[i-1]+2 if (the previous palindrom-1==currentindex char) 
else find all the previous j that match current i to see if that is a palindrom from the far left, if so break, since
you already find the longest one. but it can be better, this is very slow what I wrote here.
***/

/**
using an array of two dimension to store, so m[i][j] will be if start at i and end at j is a palindrome, and need to check
m[i+1][j-1] for induction
the matrix should be filled in the way -- triangnal, then the line above triagnle then the line above that, 
so the outside loop should be j-i which is the length of the string!! this is very important lesson
**/
class Solution {
    //using array of two dimesnion to store the information!!
     public String longestPalindrome(String s) {
	          if(s==null||s.length()==1||s.length()==0)
	          {
	              return s;
	          }
	        int length=s.length();
	        int globallength=1;
	        String globalstring=s.substring(0,1);
	        
	        boolean[][] m=new boolean[length][length];
	        int start=0;
	        //int end=0;
	        for(int i=0;i<length;i++)
	        {
	            m[i][i]=true;
	        }
	        for(int i=0;i<length-1;i++)
	        {
	            if(s.charAt(i)==s.charAt(i+1))
	            {
	                m[i][i+1]=true;
	                 if(2>globallength)
	                    {
	                        globallength=2;
	                        //globalstring=s.substring(i,i+2);
	                        start=i;
	                    }
	            }
	        }
	      
	            for(int len=2;len<length;len++)
	            {
	            	  for(int i=0;i+len<length;i++)
	      	        {
	                
	                if(m[i+1][i+len-1]&&s.charAt(i)==s.charAt(i+len))
	                {
	                    m[i][i+len]=true;
	                    if(len+1>globallength)
	                    {
	                        globallength=len+1;
	                        start=i;
	                        //globalstring=s.substring(i,j+1);
	                    }
	                }
	                
	            }
	        }
	        return s.substring(start,start+globallength);
	    }
    
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
