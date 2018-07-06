/***the two numbers is represented in a linked list and you shouls return the sum in a linkedlist
the idea is to use carry and also Queue to implement this, leetcode 2.
****/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         int carryon=0;
         Queue<Integer> stack1=new LinkedList<Integer>();
         Queue<Integer> stack2=new LinkedList<Integer>();

        while(l1!=null)
        {
            stack1.add(l1.val);
            l1=l1.next;
        }
        while(l2!=null)
        {
            stack2.add(l2.val);
            l2=l2.next;
        }
       
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(!stack1.isEmpty()&&!stack2.isEmpty())
        {  
            int n1=stack1.poll();
            int n2=stack2.poll();
            int sum=n1+n2+carryon;
            if(sum>=10)
            {
                carryon=1;
            }
            else{
                carryon=0;
            }
            //number=number*digit+num%10;
            //digit=digit*10;
            ListNode newnode=new ListNode(sum%10);
            curr.next=newnode;
            curr=newnode;
        }
        
        while(!stack1.isEmpty())
        {
            int n1=stack1.poll();
            int sum=n1+carryon;
            if(sum>=10)
            {
                carryon=1;
            }
            else
            {
                carryon=0;
            }
            curr.next=new ListNode(sum%10);
            curr=curr.next;
        }
        
          while(!stack2.isEmpty())
        {
            int n1=stack2.poll();
            int sum=n1+carryon;
            if(sum>=10)
            {
                carryon=1;
            }
            else
            {
                carryon=0;
            }
            curr.next=new ListNode(sum%10);
            curr=curr.next;
        }
        if(carryon==1)
        {
            curr.next=new ListNode(1);
        }
        
        return dummy.next;
        
    }
}
