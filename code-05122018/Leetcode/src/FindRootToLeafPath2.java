import java.util.*;
/**
 * 
 * @author yan
 * This will return all the root to leaf path  that sum to the give target value
 */
public class FindRootToLeafPath2 {
     //return a list of path that will sum up to the target.
	 public static void getAllPaths(TR root,ArrayList<ArrayList<String>> results, ArrayList<String> one, int target)
	 {
		 /**
		  * you can not do this, this is becasue, the result will be added twice, since when you recurse left, you will get the null node, 
		  * and one will be added once, when you recurse right, you will get the null node, one will be added again, that is why you have duplicate.
		  */
//		 if(root==null)
//		 {
//			 if(target==0)
//			 {
//				 results.add(new ArrayList(one));
//			 }		 
//			 return;
//		 }
		 if(root==null)
		 {
			 return;
		 }
		 //this has to add here, not below, otherwise  the last node can not be included.
		 one.add(root.name);
		 if(root.left==null&&root.right==null)
		 {
			if(root.val-target==0)
			{
			   results.add(new ArrayList(one));
			}
		 }
		 getAllPaths(root.left,results,one,target-root.val);
		 getAllPaths(root.right,results,one,target-root.val);
		 one.remove(one.size()-1);		 
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
	    
	    	//target is 619 and we expect to see the return (A,B,C,D),(A,I,O,P).
	    	ArrayList<ArrayList<String>> results=new ArrayList<ArrayList<String>>();
	    	ArrayList<String> one=new ArrayList<String>();
	    	
	    	getAllPaths(A,results,one,619);
	    	for(ArrayList<String> item:results)
	    	{
	    		for(String s:item)
	    		{
	    			System.out.print(s+",");
	    		}
	    		System.out.println("");
	    	}
	    }
}
