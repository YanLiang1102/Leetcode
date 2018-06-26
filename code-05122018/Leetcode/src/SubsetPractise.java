import java.util.*;

class SubsetPractise {
     public void getSubsets(int[] nums, int index,List<List<Integer>>res, List<Integer>one)
    {
        res.add(new ArrayList<Integer>(one));
        if(index==nums.length)
        {
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
        	//the duplicate won't get in,
        	if(i!=index&&nums[i]==nums[i-1])
        	{
        		continue;
        	}
            one.add(nums[i]);
            getSubsets(nums,i+1,res,one);
            one.remove(one.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
           List<List<Integer>> res=new ArrayList<List<Integer>>();
           List<Integer> one=new ArrayList<Integer>();
           getSubsets(nums, 0,res,one);
           return res;
    }
    
    public static void main(String[] args)
    {
    	SubsetPractise sol=new SubsetPractise();
    	int[] nums=new int[] {1,2,2};
    	List<List<Integer>> res;
    	res=sol.subsets(nums);
        for(List<Integer> item:res)
        {
        	for(int i:item)
        	{
        		System.out.print(i+",");
        	}
        	System.out.println("");
        }
    }
   
}
