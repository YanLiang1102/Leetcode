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
    public List<List<Integer>> levelOrder(TreeNode root) {
      
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
          if(root==null)
        {
          return rst;   
        }
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for(int i=0;i<size;i++)
            {
                TreeNode n=q.poll();
                temp.add(n.val);
                if(n.left!=null)
                {
                    q.add(n.left);
                }
                if(n.right!=null)
                {
                    q.add(n.right);
                }
            }
            rst.add(temp);
        }
        return rst;
    }
}
