/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
/*** 
while my idea was correct at the first place but so many typoes to fix stuff, the basic idea is to keep a map of the old node and newly created node.
****/
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        //the idea is store a mapping of the copied node and old node 
        if(head==null)
        {
            return null;
        }
        HashMap <RandomListNode, RandomListNode> map=new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy=new RandomListNode(0);
        dummy.next=new RandomListNode(head.label);
        RandomListNode oldhead=head;
        map.put(oldhead,dummy.next);
        while(head.next!=null)
        {
            RandomListNode newnode=new RandomListNode(head.next.label);
            map.put(head.next, newnode);
            head=head.next;
        }
        
        while(oldhead!=null)
        {
            RandomListNode random=map.get(oldhead.random);
            RandomListNode next=map.get(oldhead.next);
            RandomListNode current=map.get(oldhead);
            current.random=random;
            current.next=next;
            oldhead=oldhead.next;
        }
        return dummy.next;
        
    }
}
