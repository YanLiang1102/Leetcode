
/****
leetcode 238
the hard part of this is O(n) and no extra space and division is not allowed!!
****/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null||nums.length==0)
        {
            return null;
        }
        int length=nums.length;
        int[] rst=new int[length];
        rst[0]=1;
        for(int i=1;i<length;i++)
        {
            rst[i]=rst[i-1]*nums[i-1];
        }
        int right=1;
        for(int i=length-1;i>=0;i--)
        {
            rst[i]*=right;
            right*=nums[i];
        }
        return rst;
    }
}
