import java.util.*;

class ND {
	int val;
	ND next;

	public ND(int value) {
		val = value;
	}
}
/*
 * I like this problem, I think it is super fun  to work on.
 */
public class LoopDetectionInLinkedlist {

	/*
	 * check if a loop exist in the linkedlist, use classic fast and slow pointer
	 * idea
	 */
	public static boolean hasLoop(ND node) {
		if (node == null || node.next == null) {
			return false;
		}
		ND slow = node.next;
		ND fast = node.next.next;

		while (slow != fast) {
			if (slow == null || fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		// if it get out the loop which means the fast and slow pointer should collide.
		return true;
	}
	
	/*
	 * get the coliision point of the fast pointer and slow pointer
	 */
	public static ND getCollisionPoint(ND node)
	{
		if(node==null||node.next==null)
		{
			return null;
		}
		ND slow=node.next;
		ND fast=node.next.next;
		while(slow!=fast)
		{
			if(slow==null||fast==null||fast.next==null)
			{
				return null;
			}
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	public static ND getStartOfLoop(ND node)
	{
		//first find the collison point , then move one pointer to the beginning and make both of the slow and fast point to 
		//move on step each time, when they collide again , that is the start of the loop
		ND fast=getCollisionPoint(node);
		ND slow=node;
		
		//now need to find the collison
		while(slow!=fast)
		{
			if(slow==null||fast==null)
			{
				return null;
			}
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		// construct the linkedlist with a loop

		ND n1 = new ND(1);
		ND n2 = new ND(2);
		ND n3 = new ND(3);
		ND n4 = new ND(4);
		ND n5 = new ND(5);
		ND n6 = new ND(6);
		ND n7 = new ND(7);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n3;

		//expected there is a loop
		if (hasLoop(n1)) {
			System.out.println("I find a loop!");
		} else {
			System.out.println("there is no loop in the linkedlist!");
		}
		
		//expected 6
		ND collison=getCollisionPoint(n1);
		System.out.println("collison point is "+collison.val);

		//expected 3
		ND loopStart=getStartOfLoop(n1);
		System.out.println("the start of the loop is: "+loopStart.val);
	}

}
