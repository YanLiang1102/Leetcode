/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /***
 physical idea: is the single sum if has node has to start with the curr node, and it can also have nothing included, then the
 sum is 0, but for maxsum has to include one node.
 ***/
class Solution {
    class Result {
        int singlePath;
        int maxPath;/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Result {
        int singlePath;
        int maxPath;
        Result(int singlePath, int maxPath)
        {
            this.singlePath=singlePath;
            this.maxPath=maxPath;
        }
    }
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        Result r=helper(root);
        return r.maxPath;
    }
    
    public Result helper(TreeNode root)
    {
        if(root==null)
        {
            return new Result(0,Integer.MIN_VALUE);
        }
        
        Result left=helper(root.left);
        Result right=helper(root.right);
        int singlePath=Math.max(root.val+left.singlePath, root.val+right.singlePath);
        singlePath=Math.max(0,singlePath);
        int max=Math.max(left.maxPath, right.maxPath);
        //this includeing the root, will recursively at least has one node.
        max=Math.max(max,left.singlePath+root.val+right.singlePath);
        
        return new Result(singlePath,max);
    }
}
        Result(int singlePath, int maxPath)
        {
            this.singlePath=singlePath;
            this.maxPath=maxPath;
        }
    }
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        Result r=helper(root);
        return r.maxPath;
    }
    
    public Result helper(TreeNode root)
    {
        if(root==null)
        {
            return new Result(0,Integer.MIN_VALUE);
        }
        
        Result left=helper(root.left);
        Result right=helper(root.right);
        int singlePath=Math.max(root.val+left.singlePath, root.val+right.singlePath);
        singlePath=Math.max(0,singlePath);
        int max=Math.max(left.maxPath, right.maxPath);
        //this includeing the root, will recursively at least has one node.
        max=Math.max(max,left.singlePath+root.val+right.singlePath);
        
        return new Result(singlePath,max);
    }
}
