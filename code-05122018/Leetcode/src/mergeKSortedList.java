/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /****
 the idea for this one is write a customized comparator for ListNode and pass it in to the Priority Queue constructor.
 ***/
 

class Solution {
    class Newcomparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b)
        {
            return a.val-b.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists==null||lists.length==0)
        {
            return null;
        }
        if(lists.length==1&&lists[0]==null)
        {
            return null;
        }
        
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(new Newcomparator());
        for(int i=0;i<lists.length;i++)
        {
           if(lists[i]!=null)
           pq.offer(lists[i]);
        }
        
        ListNode dummy=new ListNode(0);
        ListNode head=dummy;
        while(!pq.isEmpty())
        {
            ListNode curr=pq.poll();
            ListNode next=curr.next;
            if(next!=null)
            {
                pq.add(next);    
            }            
            //here you don't need to recreate the list node just link the old ones together in a correct way.
            curr.next=null;
            head.next=curr;
            head=curr;
        }
        
        return dummy.next;
    }
}
