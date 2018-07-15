/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /***using level order  traversal***/
//The Right view contains all nodes that are last nodes in their levels, this question  means this.
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
      
         if(root==null)
             return new ArrayList<Integer>();
        
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        ArrayList<Integer> rst=new ArrayList<Integer>();
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                //q.offer(temp.)
                if(temp.left!=null)
                {
                    q.offer(temp.left);
                }
                if(temp.right!=null)
                {
                    q.offer(temp.right);
                }
                if(i==size-1)
                {
                  rst.add(temp.val);
                }
            }
        }
             
        return rst;
           
}
}
