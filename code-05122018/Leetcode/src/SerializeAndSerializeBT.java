/****
my clear submission to leetcode and pass the test in leetcode, 
serialzie and deserialize both need a queue, and when desrialize my first submission use two queues, and I enhanced that to one
queue, and the running time get better a bit
***/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*****
compared to the previous submission, this one is a bit faster since when deserialize, instead of using two queues, I am using one queue here.
*****/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
          if(root==null)
          {
              return "";
          }
          Queue<TreeNode> q=new LinkedList<TreeNode>();
          StringBuilder sb=new StringBuilder();  
          q.add(root);
          while(!q.isEmpty())
          {
              TreeNode curr=q.poll();
              if(curr==null)
              {
                  sb.append("#,");
                  continue;
              }
              sb.append(Integer.toString(curr.val)+",");
              q.offer(curr.left);
              q.offer(curr.right);
          }
        
          int count=0;
          int length=sb.length();
          int j=length-1;
          while(sb.charAt(j)=='#'||sb.charAt(j)==',')
          {
              count++;
              j--;
          }
          
          sb.setLength(sb.length()-count);
          return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if(data==null||data=="")
         {
             return null;
         }
         String[] str=data.split(",");
        
        // Queue<TreeNode> q=new LinkedList<TreeNode>();
         
        int length=str.length;
        //you don't need this extra queue here.
        //int i=0;
        
        // for(int i=0;i<length;i++)
        // {
        //   if(!str[i].equals("#"))
        //   {
        //       q.add(new TreeNode(Integer.parseInt(str[i])));
        //   }
        //   else{
        //       q.add(null);
        //   }
        // }
        
        Queue<TreeNode> newq=new LinkedList<TreeNode>();
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        newq.add(root);
        int i=1;
        while(!newq.isEmpty()&&i<length)
        {
            TreeNode curr=newq.poll();
            TreeNode left=null;
            if(!str[i].equals("#"))
            {
             left=new TreeNode(Integer.parseInt(str[i]));   
            }
            i++;
            TreeNode right=null;
            //since i is incresed inside of the loop.
            if(i<length&&!str[i].equals("#"))
            {
            right=new TreeNode(Integer.parseInt(str[i]));    
            }
            
            i++;
            if(left!=null)
            {
                curr.left=left;
                newq.offer(left);
            }
            if(right!=null)
            {
                curr.right=right;
                newq.offer(right);
            }
        }
        
        return root;
        
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
