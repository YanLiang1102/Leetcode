import java.io.*;
import java.util.*;


public class KthToLast {
	
	public static LinkedListNode getKthToLast(LinkedListNode head,int k)
	{
		LinkedListNode p1=head;
		LinkedListNode p2=head;
		
		//make p2 to the kth, then keep moving , when p2 reach the end, k2 make length-k step and p1 will go 
		//length-k step and it is kth to the last 
		for(int i=0;i<k;i++)
		{
			p2=p2.next;
			
		}
		
		while(p2!=null)
		{
			p1=p1.next;
			p2=p2.next;
		}
		
		return p1;
		
	}
	
	public static void main(String[] args)
	{
		LinkedListNode n10=new LinkedListNode(10);
		LinkedListNode n8=new LinkedListNode(8);
		LinkedListNode n6=new LinkedListNode(6);
		LinkedListNode n4=new LinkedListNode(4);
		LinkedListNode n2=new LinkedListNode(2);
		
		LinkedListNode n9=new LinkedListNode(9);
		LinkedListNode n7=new LinkedListNode(7);
		LinkedListNode n5=new LinkedListNode(5);
		LinkedListNode n3=new LinkedListNode(3);
		LinkedListNode n1=new LinkedListNode(1);
		
		
		n10.next=n8;
		n8.next=n6;
		n6.next=n4;
		n4.next=n2;
		n2.next=n9;
		n9.next=n7;
		n7.next=n5;
		n5.next=n3;
		n3.next=n1;
		
		LinkedListNode head=n10;		
		//the expected output will be 2.
		LinkedListNode result=getKthToLast(head,6);		
		System.out.println(result.val);		
	}
	
	
}
