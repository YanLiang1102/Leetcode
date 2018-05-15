import java.io.*;
import java.util.*;
import java.util.LinkedList;
	
public class PathWithSum {
	
	//recursive preorder
	public static void preorder(TR root)
	{
		if(root==null)
			return;
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}
	//recursive inorder
	public static void inorder(TR root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);	
	}
	//recursive postorder
	public static void postorder(TR root)
	{
		if(root==null)
			return;
		postorder(root.right);
		System.out.println(root.val);
		postorder(root.left);
	}
	//iterative preorder
	public static void prehelper(TR root,LinkedList<TR> stack)
	{
		if(root==null)
			return;
		stack.add(root);
		while(root.left!=null)
		{
			stack.add(root.left);
			root=root.left;
			
		}
	}
	
	//iterative method is good don't need to be afraid of this, just use stack!! you can do this!!
    public static void iterativeInorder(TR root)
    {
    	if(root==null)
    		return;
    	
    	Stack<TR> stack=new Stack<TR>();
    	stack.push(root);
    	while(root.left!=null)
    	{
    		stack.push(root.left);
    		root=root.left;
    	}
    	root=root.left;
    	TR curr=root;
    	
    	//root is the current node at the bottom left , so start dealing with the stack from there
    	while(curr!=null || !stack.isEmpty()) {
    		if(curr==null)
    		{
    			
    			curr=stack.pop();
    			System.out.println(curr.val);
    		}
    		else
    		{
    			curr=curr.right; 
    			if(curr!=null)
    			{
    				stack.push(curr);
    				while(curr.left!=null)
    				{
    					stack.push(curr.left);
    					curr=curr.left;
    				}
    				curr=curr.left;
    			}
    		}    		
    	}    	    	
    }    
    //store in a string instead of arraylist of integer
    public static void helper(TR root, String one, ArrayList<String> total)
    {
    	if(root==null)
    	{
    		return;
    			    		
    	}
    	one+=root.val+",";
    	if(root.left==null&&root.right==null)
    	{
    		total.add(one.substring(0, one.length()-1));
    	}
    	else
    	{    		
    		helper(root.left,one,total);
        	helper(root.right,one,total);
    	}
    ;
    }
    
    public static void RootToLeaf(TR root, ArrayList<String> total)
    {
       helper(root,"",total);
    }
    
    public static void helper1(TR root, ArrayList<Integer> one, ArrayList<ArrayList<Integer>> total)
    {
    	if(root==null)
    	{
    		return;
    	}
    	one.add(root.val);
    	if(root.left==null&&root.right==null)
    	{
    		total.add(new ArrayList(one));
    		//one.remove(one.size()-1);    		
    	}
    	
    	if(root.left!=null)
    	{
    		//everytime need to pass in a new one, otherwise it will get changed by other method, but this is kind of not efficient at all!!
    		helper1(root.left,new ArrayList<Integer>(one),total);
    	}
    	if(root.right!=null)
    	{
    		helper1(root.right,new ArrayList<Integer>(one),total);
    	}    
    }
    
    public static void  RootToLeaf1(TR root, ArrayList<ArrayList<Integer>>total)
    {
    	helper1(root,new ArrayList<Integer>(), total);
    }
    
    
    //brute force method to find how many path has this as the sum, get a traversal and sum it up is the idea
    public static void BruteForce(TR root, int sum,int target)
    {
      int count=0;
      if(root==null)
    	  return;
      sum+=root.val;
      if(root.left==null && root.right==null)
      {
		  System.out.println(sum);
    	  if(sum==target)
    	  {
    		  System.out.println("I find one path");
    	  }
      }
            
      if(root.left!=null)
      {
    	  BruteForce(root.left,sum,target);
      }
      if(root.right!=null)
      {
    	  BruteForce(root.right,sum, target);
      }
    }
    //static int pathcount=0;
    //ths is from root to leaf sum
    
    //need two steps one is from the root the other is not from the root, in order to figure out this problem.
    public static int GetCountOfPathFromRoot(TR root, int sum,int target)
    {    	
    	if(root==null)
    		return 0;
    	sum=sum+root.val;
    	System.out.println("hey sum: "+sum);
    	int pathcount=0;
    	if(sum==target)
    	{
    		pathcount++;
    	}
    	pathcount+=GetCountOfPathFromRoot(root.left,sum,target);
    	pathcount+=GetCountOfPathFromRoot(root.right,sum,target);
    	return pathcount;    
    }
    
    
    public static int GetCountOfPath(TR root,int target)
    {
      if(root==null)
    	  return 0;
      int rootpath=GetCountOfPathFromRoot(root,0,target);
      
      rootpath+=GetCountOfPath(root.left,target);
      rootpath+=GetCountOfPath(root.right, target);
      
      return rootpath;
    }
    
    //optimized version of get root from the path since some of the sum has been repeatedly computed, need to figure out a way how to "memorize" the already done stuff
    public static int OptimizedGetCountOfPath(TR root,int target, int runningSum, HashMap<Integer,Integer> hash)
    {
    	if(root==null)
    		return 0;
    	int pathcount=0;
    	runningSum+=root.val;
    	
    	if(runningSum==target)
    	{
    		pathcount++;
    		
    	}    	
    	
    	//int diff=target-runningSum;
    	//the running diff should be runningSUm-target the problem is all the runningSum start with the root, and root->a, root->b the diff of those will be b-a!!!
    	int diff=runningSum-target;
    	pathcount+=hash.getOrDefault(diff, 0);
    	updateHash(hash,1,runningSum);
    	pathcount+=OptimizedGetCountOfPath(root.left,target,runningSum,hash);
    	pathcount+=OptimizedGetCountOfPath(root.right,target,runningSum,hash);
    	updateHash(hash,-1,runningSum);    	
    	return pathcount;  	
    }
    
    public static void updateHash(HashMap<Integer,Integer> hash,int delta, int index)
    {
    	int newvalue=hash.getOrDefault(index, 0)+delta;
    	//if the newvalue is 0 we can remove the entry to save space.
    	if(newvalue==0)
    		hash.remove(index);
    	else
    	{
    		hash.put(index, newvalue);
    	}    	
    }
    
        
	public static void main(String[] args)
	{
		//creating the node
		TR n10=new TR(10);
		TR n5=new TR(5);
		TR nf3=new TR(-3);
		TR n3=new TR(3);
		TR n2=new TR(2);
		TR n11=new TR(11);
		TR n32=new TR(3);
		TR nf2=new TR(-2);
		TR n1=new TR(1);
		//TR n33=new TR(3);
		
		//now build up the tree
		n10.left=n5;
		n10.right=nf3;
		n5.left=n3;
		n5.right=n2;
		nf3.right=n11;
		n3.left=n32;
		n3.right=nf2;
		n2.right=n1;
		//n1.right=n33;
		
		//call the bruteForceMethod to find number of path that sum to this sum.
		//preorder(n10);
		//inorder(n10);
		//postorder(n10);
		//iterativeInorder(n10);
		//printRootToLeaf(n10);
		//ArrayList<String> test=new ArrayList<String>();
		
//	    for(String tem:test)
//	    {	    	
//	    	System.out.println(tem);	   
//	    }
//		ArrayList<ArrayList<Integer>> test =new ArrayList<ArrayList<Integer>>();
//	    RootToLeaf1(n10,test);
//	    for(ArrayList<Integer> tem:test)
//	    {
//	    	for(int i:tem)
//	    	{
//	    		System.out.print(i);
//	    		System.out.print(",");
//	    	}
//	    	System.out.println("end");
//	    }
		//BruteForce(n10,0,18);
		int test=GetCountOfPath(n10,1);
		System.out.println(test);
		
		System.out.println("get optimizde version of stuff!");
		int test1=OptimizedGetCountOfPath(n10,6,0,new HashMap<Integer,Integer>());
		System.out.println(test1);	
	}
}
