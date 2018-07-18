/***
well find the character that count less than k and split over that charatcer and do dfs, I like the idea of this problem.
****/
class Solution {
    public int longestSubstring(String s, int k) {
        if(s==null||s.length()==0)
        {
            return 0;
        }
        if(s.length()==1)
        {
            if(k==1)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        
       int[] arr=new int[26];
       ArrayList<Integer> pos=new ArrayList<Integer>();
       
       //add in the dummy beginning to do i-1;
       pos.add(-1);
       for(int i=0;i<s.length();i++)
       {
           arr[s.charAt(i)-'a']++;
       }
       for(int i=0;i<s.length();i++)
       {
           if(arr[s.charAt(i)-'a']<k)
           {
               pos.add(i);
           }
       }
       //this is the return condition since -1 already added.
        if(pos.size()==1) return s.length();
        pos.add(s.length());
        int max=0;
        for(int i=1;i<pos.size();i++)
        {
        //since start is +1 that is why the dummy start should be -1 added above instead of 0.
            int start=pos.get(i-1)+1;
            int end=pos.get(i);
            int temp=longestSubstring(s.substring(start,end),k);
            max=Math.max(max,temp);
        }
    
       return max;
    }
    
}
