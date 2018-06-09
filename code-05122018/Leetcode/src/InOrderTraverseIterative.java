import java.util.*; 
/*
 *it also implemented in pathofSumProblem, but the current solution is better all written by myself.
 * 
 */
public class InOrderTraverseIterative {

	public static void inorder(TR root)
	{
		if(root==null)
		{
			return;
		}
		Stack<TR> stack=new Stack<TR>();
		stack.push(root);
		TR curr=root;
		
		while(curr!=null||!stack.isEmpty())
		{
			//if curr is not null then it is the right node, then we need to push all its left to the stack.
			if(curr!=null)
			{
				while(curr.left!=null)
				{
					curr=curr.left;
					stack.push(curr);
					
				}				
			}
										
			TR tmp=stack.pop();
			System.out.println(tmp.val+",");
			curr=tmp.right;
			if(curr!=null)
			{
				stack.push(curr);	
			}
			
		}
		
	}
	
	public static void main(String[] args)
	{
		//n1 is the root
		TR n1=new TR(1);
		TR n2=new TR(2);
		TR n3=new TR(3);
		TR n4=new TR(4);
		TR n5=new TR(5);
		TR n6=new TR(6);
		TR n7=new TR(7);
		
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		n5.right=n6;
		n3.left=n7;
		
		
		inorder(n1);
		
	}
	
}
