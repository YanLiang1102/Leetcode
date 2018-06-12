import java.util.*;

public class findLCA {
	
	//@SuppressWarnings("unused")
	public static TR findLCAData(TR root, TR n1, TR n2)
	{
		if(root==null)
		{
			return null;
		}
		if(root==n1||root==n2)
		{
			return root;
		}
		TR left=findLCAData(root.left,n1,n2);
		TR right=findLCAData(root.right,n1,n2);
		if(left!=null&&right!=null)
		{
			return root;
		}
		else if(left!=null)
		{
			return left;
		}
		else if(right!=null)
		{
			return right;
		}
		return null;
		
	}
	

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
    	//B.N retrun A,D,E=>C, H,C=>B
    	TR rst1=findLCAData(A,B,N);
    	System.out.println(rst1.name);
    	TR rst2=findLCAData(A,D,E);
    	System.out.println(rst2.name);
    	TR rst3=findLCAData(A,H,C);
    	System.out.println(rst3.name);
    	
    	
		
	}
}
