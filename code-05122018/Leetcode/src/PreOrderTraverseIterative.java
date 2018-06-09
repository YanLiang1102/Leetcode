import java.util.*;

public class PreOrderTraverseIterative {
	
	public static void preOrder(TR root)
	{
		if(root==null)
		{
			return;
		}
		Stack <TR> stack=new Stack<TR>();
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			TR curr=stack.pop();
			System.out.println(curr.val);
			if(curr.right!=null)
			{
				stack.push(curr.right);
			}
			if(curr.left!=null)
			{
				stack.push(curr.left);
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
		
		
	   preOrder(n1);
		
	}
	
}
