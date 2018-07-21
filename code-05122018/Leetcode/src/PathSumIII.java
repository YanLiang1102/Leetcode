/***
leetcode 437, very nice problem apply presum to it, very much like it so it consider if the path will end at the current node
I have several solution in leetcode, one is pass the count[] around , another is to make the helper return an int value.
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
     //int count=0;
    
    public int pathSum(TreeNode root, int sum) {
        
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        //this is to make sure the currsum is target so make sure the solution from the root get included!
        map.put(0,1);
        int[] count=new int[1];
        helper(root,map,0,sum,count);
        return count[0];
        
    }
   
    public void helper(TreeNode root, HashMap<Integer,Integer> map,int currsum, int target,int[] count)
    {
        if(root==null)
        {
            return;
        }
        currsum+=root.val;
        if(map.containsKey(currsum-target))
        {
            count[0]+=map.get(currsum-target);
        }
      
        if(!map.containsKey(currsum))
        {
           map.put(currsum,1);
        }
        else
        {
            map.put(currsum,map.get(currsum)+1);
        }
    
        helper(root.left,map, currsum, target,count);
        helper(root.right,map, currsum, target,count);
        map.put(currsum, map.get(currsum)-1);
    }
    
}
