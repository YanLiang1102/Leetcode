//just a dfs backtracking problem, naive idea to find all the fatcors.
public class Solution {
    /**
     * @param n: a integer
     * @return: return a 2D array
     */
    //find factors for number n
    public List<Integer> findFactors(int n)
    {
       List<Integer> rst=new ArrayList<Integer>();
       
       for(int i=2;i<n;i++)
       {
           if(n%i==0)
           {
             rst.add(i); 
           }
       }
       return rst;
    }
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        List<Integer> one=new ArrayList<Integer>();
        List<Integer> factors=findFactors(n);
        helper(rst, one,factors,n,0);
        return rst;
    }
    
    public void helper(List<List<Integer>> rst, List<Integer> one, List<Integer> factors,int remain, int index)
    {
        if(remain==1)
        {
            rst.add(new ArrayList<Integer>(one));
            return;
        }
        
        for(int i=index;i<factors.size();i++)
        {
            int factor=factors.get(i);
            if(remainúctor==0)
            {
              one.add(factor);
              helper(rst,one,factors,remain/factor,i);
              one.remove(one.size()-1);
            }
        }
        
        
    }
}
