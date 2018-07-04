import java.util.*;
class returntype {
	int globalindex;
	int globalmax;
	 returntype(int globalindex,int globalmax)
	{
		this.globalindex=globalindex;
		this.globalmax=globalmax;
	}
}

public class LongestIncreasingSequence {
    public static returntype findLongestSubsequence(int[] nums,ArrayList<ArrayList<Integer>> res)
    {
    	//=new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> first=new ArrayList<Integer>();
    	first.add(nums[0]);
    	res.add(first);
    	int globalmax=1;
    	int globalindex=0;
    	for(int i=1;i<nums.length;i++)
    	{
    		int maxindex=-1;
    		int maxlength=Integer.MIN_VALUE;
    		for(int j=0;j<i;j++)
    		{
    			if(nums[i]>nums[j]&&res.get(j).size()>maxlength)
    			{
    				maxlength=res.get(j).size();
    				maxindex=j;
    			}
    		    			
    		}
    		ArrayList<Integer> copy=new ArrayList<Integer>();
			if(maxindex!=-1)
			{
				copy=new ArrayList<Integer>(res.get(maxindex));
			}
			copy.add(nums[i]);
			res.add(copy);
			if(maxlength+1>globalmax)
			{
				globalmax=maxlength+1;
				globalindex=i;
			}
		    
			
    	}
    	return new returntype(globalindex,globalmax);
    }
	
    public static void main(String[] args)
    {
    	int[] nums=new int[9];
    	
    	nums[0]=10;
    	nums[1]=22;
    	nums[2]=9;
    	nums[3]=33;
    	nums[4]=21;
    	nums[5]=50;
    	nums[6]=41;
    	nums[7]=60;
    	nums[8]=80;
    	ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    	returntype longest=findLongestSubsequence(nums,res);
        
    	System.out.println(longest.globalmax);
    	
    	for(int num:res.get(longest.globalindex))
    	{
    		System.out.print(num+",");
    	}
    }
	
	
}
