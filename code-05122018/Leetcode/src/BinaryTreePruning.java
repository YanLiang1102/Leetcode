//use a helper to check if the subtree all contains 0 and use bfs to loop through each node, if its left or right is qualified , set them to null.
```
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
    public TreeNode pruneTree(TreeNode root) {
        
        if(root==null)
        {
            return root;
        }
        if(root.left==null&&root.right==null)
        {
            if(root.val==0)
                return null;
            else
                return root;
        }
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode curr=q.poll();
            if(helper(curr.left))
            {
                curr.left=null;
            }
            else
            {
                if(curr.left!=null)
                {
                 q.add(curr.left);   
                }                
            }
            if(helper(curr.right))
            {
                 curr.right=null;                                                
            }
            else
            {
                if(curr.right!=null)
                {
                 q.add(curr.right);   
                }                
            }
           
        }
        return root;
    }
    //to check if the subtree start with this node is qualified
    public boolean helper(TreeNode root)
    {
        if(root==null)
        {
            return true;
        }
        if(root.val==1)
        {
            return false;
        }
        
        return helper(root.left)&&helper(root.right);    
    }
}
```
