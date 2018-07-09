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
    public boolean order(TreeNode p, TreeNode q)
    {
        if(p.val>q.val)
        {
            return false;
        }
        return true;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //the idea is if they are on the same branch keep finding what is teh next one,
        //if they are on the different branch the current node will be the root.
        if(root==null)
        {
            return null;
        }
        
        if(order(p,q))
        {
            if(root.val>=p.val&&root.val<=q.val)
            {
                return root;    
            }
            else if(root.val>=q.val)
            {
                return lowestCommonAncestor(root.left,p,q);
            }
            else if(root.val<=p.val)
            {
                return lowestCommonAncestor(root.right,p,q);
            }
            
        }
        else if(!order(p,q))
        {
            if( root.val<=p.val &&root.val>=q.val)
            return root;        
                else if(root.val>=p.val)
            {
                return lowestCommonAncestor(root.left,p,q);
            }
            else if(root.val<=q.val)
            {
                return lowestCommonAncestor(root.right,p,q);
            }   
        }
        return null;
    }
}
