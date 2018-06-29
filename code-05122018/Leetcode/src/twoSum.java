//solutions I write in lintcode directly, so when the input array is sorted.
public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int i=0;
        int j=nums.length-1;
        int[] result=new int[2];
        while(i<j)
        {
            if(nums[i]+nums[j]==target)
            {
                result[0]=i+1;
            result[1]=j+1;
            return result;
            }
            else if(nums[i]+nums[j]<target)
            {
                i++;
            }
            else{
                j--;
            }
        }
        return result;
        
    }
}
