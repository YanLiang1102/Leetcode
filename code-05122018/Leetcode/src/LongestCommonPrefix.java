class Solution {
    public String findShortestString(String[] strs)
    {
        String rst=strs[0];
        for(int i=1;i<strs.length;i++)
        {
            if(strs[i].length()<rst.length())
            {
                rst=strs[i];
            }
        }
        return rst;
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
        {
            return "";
        }
        if(strs.length==1)
        {
            return strs[0];
        }
        
        String shortest=findShortestString(strs);
       
            String prefix="";
            for(int j=1;j<=shortest.length();j++)
            {
                prefix=shortest.substring(0,j);
                for(int i=0;i<strs.length;i++)
                {
                //this can not be contains, otherwise "ca" and "a" would return "a"
                    if(!strs[i].substring(0,j).equals(prefix))
                    {
                            return shortest.substring(0,j-1);
                    }
                }
            }
        
          return shortest;
            
       
        
    }
}
