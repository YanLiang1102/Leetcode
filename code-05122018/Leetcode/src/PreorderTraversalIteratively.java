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
    //traverse this iteratively, this is passed in one try iteratively I am proud.
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst=new ArrayList<Integer>();
        if(root==null)
        {
            return rst;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while(root.left!=null||!stack.isEmpty())
        {
            TreeNode curr=null;
            if(root.left==null)
            {
                curr=stack.pop();
                rst.add(curr.val);
                if(curr.right!=null)
                {
                    root=curr.right;
                    stack.push(curr.right);
                }
               
            }
            else{
                stack.push(root.left);
                root=root.left;    
            }
            
        }
        return rst;
        
    }
}
