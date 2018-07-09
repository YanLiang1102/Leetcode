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
 This solution is accepted but super slow!!!
 ***/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q)
        {
            return root;
        }
//         if(isParent(root.left,p)&&isParent(root.left,q))
//         {
//             return lowestCommonAncestor(root.left,p,q);
//         }
//         else if(isParent(root.right,p)&&isParent(root.right,q))
//         {
//             return lowestCommonAncestor(root.right,p,q);
//         }
//         else if((isParent(root.left,p)&&isParent(root.right,q))||(isParent(root.right,p)&&isParent(root.left,q)))
//         {
//             return root;
//         }
//         return null;
     //you don't need to check isParent, change to check if it is null or not will help check if it is parent, but
     //help you save a lot of time! and this become a much better solution.
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null)
        {
            return root;
        }
        else if(left!=null)
        {
            return left;
        }
        else if(right!=null)
        {
            return right;
        }
        return null;
    }
    
    public boolean isParent(TreeNode root, TreeNode n)
    {
        if(root==null)
        {
            return false;
        }
        if(root==n)
        {
            return true;
        }
        return isParent(root.left,n)||isParent(root.right,n);
        
    }
}
