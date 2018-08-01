class Solution {
    public List<String> summaryRanges(int[] nums) {
        //just looping through the array only needs to be careful when to update start and end.                
        List<String> rst=new ArrayList<String>();
        if(nums==null||nums.length==0)
        {
            return rst;
        }
        int len=nums.length;
        int start=nums[0];
        int prev=start;
        int end=nums[0];
        for(int i=1;i<len;i++)
        {
            if(nums[i]==prev+1)
            {
                end=nums[i];
                prev=nums[i];
                continue;
            }
            //now time to find what is the start and end;
            else
            {
                //build the result
                buildString(rst,start,end);
                start=nums[i];
                prev=nums[i];
                end=nums[i];
            }
        }
        //thsi is for the array ends without build the last string yet.
        buildString(rst,start,end);
        return rst;
    }
    
    public void buildString(List<String>rst, int start, int end)
    {
        if(start!=end)
        rst.add(start+"->"+end);
        else
        rst.add(String.valueOf(start));        
    }
   
}
