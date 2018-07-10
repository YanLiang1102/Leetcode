/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack=new Stack<ListNode>();
        while(head!=null)
        {
            stack.push(head);
            head=head.next;
        }
        ListNode dummy=new ListNode(0);
        ListNode newhead=dummy;
        while(!stack.isEmpty())
        {
            ListNode curr=stack.pop();
            //forget this will set the code in to a dead loop!!!! since it will be a circle if you think about it!!!
            curr.next=null;
            newhead.next=curr;
            newhead=curr;
        }
        return dummy.next;
        
    }
}
