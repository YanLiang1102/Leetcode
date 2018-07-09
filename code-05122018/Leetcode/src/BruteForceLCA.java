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
        if(isParent(root.left,p)&&isParent(root.left,q))
        {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(isParent(root.right,p)&&isParent(root.right,q))
        {
            return lowestCommonAncestor(root.right,p,q);
        }
        else if((isParent(root.left,p)&&isParent(root.right,q))||(isParent(root.right,p)&&isParent(root.left,q)))
        {
            return root;
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
