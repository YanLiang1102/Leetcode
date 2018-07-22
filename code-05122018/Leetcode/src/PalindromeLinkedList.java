/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //without a stack with reverse make it O(1) space., you can also use a stack but the space is going to be O(n)
    //in that way you don't need to reverse the first half of the linkedlist.
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
        {
            return true;
        }
        ListNode dummy=head;
        ListNode dummy1=head;
        ListNode prev=null;
        int length=getlength(dummy);
        int half=length/2;
        ListNode temp=null;
        
        int count=0;
        
        //reverse the first half at the same time in this way you don't need a stack to store the previous infortion, using this it gets super fast!
        
        while(count<half)
        {                
            count++;
            temp=dummy1;
            dummy1=dummy1.next;
            if(prev!=null)
            {
                temp.next=prev;
            }
            prev=temp;                                       
        }
        
        //if it is odd, need to go one step forward.
        if(length%2==1)
        {
        dummy1=dummy1.next;    
        }
            
        while(dummy1!=null&&temp!=null)
        {
            if(dummy1.val==temp.val)
            {
                dummy1=dummy1.next;
                temp=temp.next;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    
    public int getlength(ListNode head)
    {
       int count=0;
       while(head!=null)
       {
           count++;
           head=head.next;
       }
        return count;
        
    }
}
