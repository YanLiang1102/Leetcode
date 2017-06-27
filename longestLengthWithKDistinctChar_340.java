class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        if(s==null||s.length()==0)
         return 0;
         int best=0;
         int left=0;
         for(int i=0;i<s.length();i++)
         {
             char current=s.charAt(i);
             if(map.containsKey(current))
             {
                 map.put(current,map.get(current)+1);
             }
             else
             {
                 map.put(current,1);
             }
             while(map.size()>k)
             {
                char leftchar=s.charAt(left);
                left=left+1;
                if(map.get(leftchar)==1)
                  {
                   map.remove(leftchar);
                   break;   
                  }
                  
                map.put(leftchar,map.get(leftchar)-1);
             }
             best=Math.max(best,i-left+1);
             
         }
         return best;
    }
}
