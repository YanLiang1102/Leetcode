/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//using a hash if need to use no extra space need to use slow and fast pointer.
public class Solution {
    public boolean hasCycle(ListNode head) {
        //store the visited in a hash to see before it ends, can you see that again in the hash
        if(head==null||head.next==null)
        {
            return false;
        }
        HashSet<ListNode> set =new HashSet<ListNode>();
        set.add(head);
        while(head.next!=null)
        {
            if(set.contains(head.next))
            {
                return true;
            }
            head=head.next;
            set.add(head);
        
        }
        return false;
    }
}

//using two pointer with no extra space
public class Solution {
    public boolean hasCycle(ListNode head) {
        //store the visited in a hash to see before it ends, can you see that again in the hash
        if(head==null||head.next==null)
        {
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        
        while(fast!=null&&fast.next!=null)
        {
            if(fast==slow)
            {
                return true;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return false;
    }
}
