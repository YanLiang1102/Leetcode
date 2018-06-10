import java.util.*;
/*
 * this problem is p160 10.6 find a root to leaf path with specific sum, just return a boolean
 */
public class FindRootToLeafPath {
	public static boolean hasPathSum(TR root,int target)
	{
		if(root==null)
		{ 
			if(target==0)
			{
				return true;
			}
			else
			{
				return false;
			}	
		}
		
		return hasPathSum(root.left, target-root.val)||hasPathSum(root.right, target-root.val);
	}
		
	//the tree is on p151 of the book
    public static void main(String[] args)
    {
    	TR A=new TR(314,"A");
    	TR B=new TR(6,"B");
    	TR C=new TR(271,"C");
    	TR D=new TR(28,"D");
    	TR E=new TR(0,"E");
    	TR F=new TR(561,"F");
    	TR G=new TR(3,"G");
    	TR H=new TR(17,"H");
    	TR I=new TR(6,"I");
    	TR J=new TR(2,"J");
    	TR K=new TR(1,"K");
    	TR L=new TR(401,"L");
    	TR M=new TR(641,"M");
    	TR N=new TR(257,"N");
    	TR O=new TR(271,"O");
    	TR P=new TR(28,"P");
    	
    	A.left=B;
    	A.right=I;
    	B.left=C;
    	B.right=F;
    	C.left=D;
    	C.right=E;
    	F.right=G;
    	G.left=H;
    	I.left=J;
    	I.right=O;
    	J.right=K;
    	K.left=L;
    	K.right=N;
    	L.right=M;
    	O.right=P;
    	System.out.println("expect to see 580");
    	if(hasPathSum(A,580))
    	{
    		System.out.println("there is root to leaf sum to 580");
    	}
    	else
    	{
    		System.out.println("there is no root to leaf sum to 580");
    	}
    	
    	System.out.println("expect to see 591");
    	if(hasPathSum(A,591))
    	{
    		System.out.println("there is root to leaf sum to 591");
    	}
    	else
    	{
    		System.out.println("there is no root to leaf sum to 591");
    		
    	}
    	System.out.println("expect to see 619");
    	if(hasPathSum(A,619))
    	{
    		System.out.println("there is root to leaf sum to 619");
    	}
    	else
    	{
    		System.out.println("there is no root to leaf sum to 619");
    	}
    	System.out.println("not expect to see 620");
    	if(hasPathSum(A,620))
    	{
    		System.out.println("there is root to leaf sum to 620");
    	}
    	else
    	{
    		System.out.println("there is no root to leaf sum to 620");
    		
    	}
    }

}
