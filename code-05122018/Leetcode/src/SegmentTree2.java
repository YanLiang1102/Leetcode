import java.util.*;

/**
 * the inout will be an array and the range of the node will be the index of the array
 * @author yan
 *
 */
public class SegmentTree2 {
	
	public SegmentTreeNode2 build(int start, int end,int[] arr)
	{
	 //do the left and right node should be top down but the max value should be built bottom up
	    SegmentTreeNode2 root=new SegmentTreeNode2(start,end,Integer.MIN_VALUE);
	    if(start>end)
	    {
	    	return  null;
	    }
	    else if(start<end)
	    {
	    	int mid=(start+end)/2;
	    	SegmentTreeNode2 left=build(start,mid,arr);
	    	SegmentTreeNode2 right=build(mid+1,end,arr);
	    	root.left=left;
	    	root.right=right;
	    	root.max=Math.max(left.max, right.max);
	    }
	    //if start and end are equal
	    else
	    {
	    	root.max=arr[start];
	    }
		
		return root;
		
	}
	
	public static void main(String[] args)
	{
		int[] arr=new int[4];
		arr[0]=3;
		arr[1]=2;
		arr[2]=1;
		arr[3]=4;
		SegmentTree2 t=new SegmentTree2();
		SegmentTreeNode2 root=t.build(0,arr.length-1,arr);
		
		//in one we print the result out in a dfs way now we print the result out in a bfs way
		Queue<SegmentTreeNode2> q=new LinkedList<SegmentTreeNode2>();
	    q.offer(root);
	    while(!q.isEmpty())
	    {
	    	SegmentTreeNode2 curr=q.poll();
	    	//System.out.println(String.format("start {0}, end {1},max {2}",curr.start, curr.end,curr.max));
	    	System.out.println(curr.start+", "+curr.end+", "+curr.max);
	        if(curr.left!=null)
	        	q.offer(curr.left);
	        if(curr.right!=null)
	        	q.offer(curr.right);
	    }
		
		
	}
	
}
