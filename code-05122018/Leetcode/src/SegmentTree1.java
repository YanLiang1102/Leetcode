import java.util.*;

public class SegmentTree {

	
	public SegmentTreeNode build (int start, int end)
	{
		SegmentTreeNode root=new SegmentTreeNode(start,end);
		
		if(start<end)
		{
			root.left=build(start,(start+end)/2);
			root.right=build((start+end)/2+1,end);
		}
		return root;// new SegmentTreeNode(start,end);
	}
	public static void main(String[] args)
	{
		SegmentTree t=new SegmentTree();
		SegmentTreeNode root=t.build(1,6);
		
		
	    Stack<SegmentTreeNode> stack=new Stack<SegmentTreeNode>();
	    stack.push(root);	    
	    while(!stack.isEmpty())
	    {
	       SegmentTreeNode curr=stack.pop();
	       System.out.println(curr.start+", "+curr.end);
	       if(curr.right!=null)
	    	   stack.push(curr.right);
	       if(curr.left!=null)
	    	   stack.push(curr.left);
	    	
	    }
	}
}
