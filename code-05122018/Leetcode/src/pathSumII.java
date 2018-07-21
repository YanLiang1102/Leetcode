/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/****
path sum 1 and 2 are good dfs problem.
****/

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        List<Integer> one=new ArrayList<Integer>();
        if(root==null)
        {
            return rst;
        }
        helper(rst,one, sum, root);
        //helper()
        return rst;
    }
    
    public void helper(List<List<Integer>> rst, List<Integer> one, int sum, TreeNode root)
    {
       
         
         if(root.left==null&&root.right==null)
         {
             if(sum==root.val)
             {
                 one.add(root.val);
                 rst.add(new ArrayList<Integer>(one));
                 one.remove(one.size()-1);
             }
             return;
         }
        
         
         if(root.left!=null)
         {
             one.add(root.val);
             helper(rst,one,sum-root.val,root.left);
             one.remove(one.size()-1);
         }
        
         
         if(root.right!=null)
         {
             one.add(root.val);
             helper(rst,one, sum-root.val,root.right);
             one.remove(one.size()-1);
         }
         
        
    }
}
