

/***definitely working in eclipse but not leetcode, leetcode testing has problem....
this problem is same as the binary tree in order traversal I mean iteratively
****/
import java.util.*;
public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode root;
    public BSTIterator(TreeNode root) {
        this.stack=new Stack<TreeNode>();
        this.root=root;
        if(root!=null)
        {
            this.stack.push(root);   
        }
    
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
       if((root!=null&&root.left!=null)||!stack.isEmpty())
       {
           return true;
       }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
       while(root!=null&&root.left!=null)
       {
           stack.push(root.left);
           root=root.left;
           
       }
       
       //well here you don't update the root, otherwise you are going to retraverse whatever you have been traverse before.
       TreeNode curr=stack.pop();
       int value=curr.val;
       
       if(curr.right!=null)
       {
           stack.push(curr.right);
           root=curr.right;
       }
        return value;
    }
    public static void main(String[] args)
    {
    	TreeNode root=new TreeNode(4);
    	//TreeNode left=new TreeNode(1);
    	//TreeNode right=new TreeNode(3);
    	TreeNode n3=new TreeNode(3);
    	TreeNode n1=new TreeNode(1);
    	TreeNode n2=new TreeNode(2);
    	
    	TreeNode n5=new TreeNode(5);
    	TreeNode n8=new TreeNode(8);
    	
    	root.left=n3;
    	root.right=n5;
    	n5.right=n8;
    	n3.left=n1;
    	n3.right=n2;
//    	
//    	root.left=left;
//    	root.right=right;
    	
    	 BSTIterator i = new BSTIterator(root);
    	 while (i.hasNext()) 
    		 System.out.println(i.next());
    	
    }
   
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
