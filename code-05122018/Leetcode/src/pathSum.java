/***
leetcode 112, one thing be careful is that:
the end node of the path has to be a leaf, that is why I am checking that in this way
***/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
        {
            return false;
        }
         
       return helper(root, sum);
    }
    
    public boolean helper(TreeNode root,int sum)
    {
        //thsi is means it is leaf the end node has to be a leaf!
        if(root.left==null&&root.right==null)
        {
            if(sum==root.val)
            {
                return true;
            }
            return false;
        }
        
       boolean left=false;
       boolean right=false;
       if(root.left!=null)
       {
           left=helper(root.left,sum-root.val);
       }
       if(root.right!=null)
       {
           right=helper(root.right,sum-root.val);
       }
        return left||right;
    }
}
