/***there is an error here , but I have no idea what is wrong with it"
****/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)
        {
            return 0;
        }
        if(s.length()==1)
        {
            return 1;
        }
        char [] arr=s.toCharArray();
        int[] m=new int[s.length()];
        //abcabcbb
        m[0]=1;
        int globalmax=0;
        for(int i=1;i<s.length();i++)
        {
            char c=arr[i];
            int startindex=i-m[i-1];
            int index=s.substring(startindex,i).indexOf(c);
            if(index<0)
            {
                m[i]=m[i-1]+1;
            }
            else
            {
                //did not add the startindex here, that why it does not get passed at the first place on leetcode.
                m[i]=i-(index+startindex);
            }
            globalmax=Math.max(globalmax,m[i]);
        }
        
        return globalmax;
    }
}
