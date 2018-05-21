import java.io.*;

public class DeleteMiddleNode {
	
	/*
	 * Dnode is the node to be deleted, and you don't have access to the head , you only have access of the toBeDeleted Node.
	 */
	public static void deleteMiddleNode(LinkedListNode dNode)
	{
		//copy the nextnode value over to this node and delete the next node.
		LinkedListNode next=dNode.next;
		dNode.val=next.val;
	    dNode.next=next.next;
	    next.next=null;
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
		
		System.out.println("before delete:");
		//before delete node 4
		while(head!=null)
		{
			System.out.print(head.val+",");
			head=head.next;
		}
		System.out.println("");
		LinkedListNode head1=n10;
		deleteMiddleNode(n4);
		System.out.println("after delete:");
		while(head1!=null)
		{
			System.out.print(head1.val+",");
			head1=head1.next;
		}
		
	}
}
