import java.io.*;
import java.util.*;

public class PartitionLinkedList {
	
	//the idea is keep two linked list ,one keep the less than part, one keep the bigger than part and merge them together later
	/*
	 * pValue is the partition value
	 */
    public static LinkedListNode partitionLinkedList(LinkedListNode head,int pValue)
    {
    	//this will be the dummy head
    	LinkedListNode smallerHead=new LinkedListNode(0);
    	LinkedListNode dummyhead1=smallerHead;
    	LinkedListNode biggerHead=new LinkedListNode(0);
    	LinkedListNode dummyhead2=biggerHead;
    	
    	while(head!=null)
    	{
    		if(head.val<pValue)
    		{
    			smallerHead.next=head;
    			smallerHead=smallerHead.next;
    		}
    		else
    		{
    			biggerHead.next=head;
    			biggerHead=biggerHead.next;
    		}
    		head=head.next;
    	}
    	//since the biggerhead.next might not be null need to set this to be null.
    	biggerHead.next=null;
    	//then merge the two list together
    	//since dummyhead2 itself is a fake node
    	smallerHead.next=dummyhead2.next;
    	return dummyhead1.next;
    	
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
		
		LinkedListNode newhead=partitionLinkedList(n10,7);
		while(newhead!=null)
		{
			System.out.print(newhead.val+",");
			newhead=newhead.next;
		}
		
	}
	
	
	
	
}
