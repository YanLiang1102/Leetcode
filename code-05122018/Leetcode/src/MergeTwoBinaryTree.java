/****
using recursion to do this and i get a one time pass there, yeh!
****/
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
    //class doubleNode
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        TreeNode t;
        if(t1==null)
        {
            return t2;
        }
        if(t2==null)
        {
            return t1;
        }
        
        TreeNode left1=mergeTrees(t1.left, t2.left);
        TreeNode right1=mergeTrees(t1.right, t2.right);
        
        int value=getValue(t1)+getValue(t2);
        t=new TreeNode(value);
        t.left=left1;
        t.right=right1;
        return t;
    }
    
    public int getValue(TreeNode t)
    {
        if(t==null)
            return 0;
        else 
            return t.val;
    }
}


//second time practise this.
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null)
        {
            return t2;
        }
        if(t2==null)
        {
            return t1;
        }
        TreeNode root=new TreeNode(t1.val+t2.val);
        TreeNode mergeleft=mergeTrees(t1.left,t2.left);
        TreeNode mergeright=mergeTrees(t1.right,t2.right);
        root.left=mergeleft;
        root.right=mergeright;
        
        return root;
        
        
    }
}
