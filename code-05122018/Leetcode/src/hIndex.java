class Solution {
    public int hIndex(int[] citations) {
        
        if(citations==null||citations.length==0)
        {
            return 0;
        }
        if(citations.length==1)
        {
            if(citations[0]>=1)
                return 1;
            return 0;
        }
        
        int len=citations.length;
        Arrays.sort(citations);
        
        int[] count=new int[len+2];
        for(int i=len;i>=1;i--)
        {
            //i+1 that is why need to define the length as len+2 there
            int previouscount=count[i+1];
            count[i]=previouscount;
            
            for(int j=len-previouscount-1;j>=0;j--)
            {
                if(citations[j]>=i)
                {
                    count[i]++;
                }
                else{
                    break;
                }
            }
            
            if(count[i]>=i)
            {
                if(len-i-1>=0&&citations[len-i-1]<=i)
                {
                    return i;
                }
                if(len-i-1<0)
                {
                    return i;
                }
               
            }
        }
        
        return 0;
        
        
    }
}
