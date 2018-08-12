class Solution {
    //well this is like heibang huo bing , the one that last left will be the winner
    class Pair{
        int value;
        int count;
        public Pair(int value, int count)
        {
            this.value=value;
            this.count=count;
        }
    }
    public int majorityElement(int[] nums) {
        
        if(nums==null||nums.length==0)
        {
            return 0;
        }
        
        int len=nums.length;
        Pair rst=new Pair(nums[0],1);
        for(int i=1;i<len;i++)
        {
            if(nums[i]==rst.value)
            {
                //result[0]=null;
                rst.count=rst.count+1;
            }
            else
            {
                if(rst.count==0)
                {
                  //update the count and value
                    rst.value=nums[i];
                    rst.count=1;
                    continue;
                }
                if(rst.count>0)
                {
                 rst.count=rst.count-1;   
                }
                
            }
        }
        
        if(rst.count!=0)
        {
            return rst.value;
        }
        
        return 0;
        
        
    }
}
